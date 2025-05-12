package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.DemoApplication;
import com.example.demo.service.ArticleService;
import com.example.demo.service.MemberService;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.Member;
import com.example.demo.vo.ResultData;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UserMemberController {

	private final DemoApplication demoApplication;

	@Autowired
	private MemberService memberService;

	UserMemberController(DemoApplication demoApplication) {
		this.demoApplication = demoApplication;
	}

	@RequestMapping("/user/member/doLogout")
	@ResponseBody
	public ResultData doLogout(HttpSession session) {
		boolean isLogined = false;

		if (session.getAttribute("loginedMemberId") != null) {
			isLogined = true;
		}

		if (!isLogined) {
			return ResultData.from("F-A", "이미 로그아웃한 상태입니다.");
		}

		session.removeAttribute("loginedMemberId");

		return ResultData.from("S-1", Ut.f("로그아웃 되었습니다."));
	}

	// 액션 메서드
	@RequestMapping("/user/member/doJoin")
	@ResponseBody
	public ResultData<Member> doJoin(HttpSession session, String loginId, String loginPw, String name, String nickname,
			String email) {

		boolean isLogined = false;

		if (session.getAttribute("loginedMemberId") != null) {
			isLogined = true;
		}

		if (isLogined) {
			return ResultData.from("F-A", "이미 로그인중입니다.");
		}

		if (Ut.isEmptyOrNull(loginId)) {
			return ResultData.from("f-1", "아이디를 입력해주세요.");
		}

		if (Ut.isEmptyOrNull(loginPw)) {
			return ResultData.from("f-2", "비밀번호를 입력해주세요.");
		}

		if (Ut.isEmptyOrNull(name)) {
			return ResultData.from("f-3", "이름을 입력해주세요.");
		}

		if (Ut.isEmptyOrNull(email)) {
			return ResultData.from("f-4", "이메일을 입력해주세요.");
		}

		if (Ut.isEmptyOrNull(nickname)) {
			return ResultData.from("F-5", "닉네임을 입력해주세요.");

		}

		ResultData doJoinRd = memberService.joinMember(loginId, loginPw, name, nickname, email);

		if (doJoinRd.isfail()) {
			return doJoinRd;
		}

		Member member = memberService.getMemberById((int) doJoinRd.getData1());

		return ResultData.newData(doJoinRd, "새로 생성된 member", member);
	}

	@RequestMapping("/user/member/doLogin")
	@ResponseBody
	public ResultData<Member> doLogin(HttpSession session, String loginId, String loginPw) {

		boolean isLogined = false;

		if (session.getAttribute("loginedMemberId") != null) {
			isLogined = true;
		}

		if (isLogined) {
			return ResultData.from("F-A", "이미 로그인중입니다.");
		}

		if (Ut.isEmptyOrNull(loginId)) {
			return ResultData.from("f-1", "아이디를 입력해주세요.");
		}

		if (Ut.isEmptyOrNull(loginPw)) {
			return ResultData.from("f-2", "비밀번호를 입력해주세요.");
		}

		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			return ResultData.from("F-3", Ut.f("%s는(은) 없는 아이디입니다.", loginId));
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return ResultData.from("F-4", "비밀번호가 일치하지 않습니다.");
		}

		session.setAttribute("loginedMemberId", member.getId());

		return ResultData.from("S-1", Ut.f("%s님 환영합니다.", member.getName()), "로그인한 회원", member);

	}

//	@RequestMapping("/user/member/getMembers")
//	@ResponseBody
//	public List<Member> getMembers() {
//
//		return memberService.getMembers();
//	}

}
