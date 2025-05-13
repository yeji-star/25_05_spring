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
import com.example.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;
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

	// 로그아웃

	@RequestMapping("/user/member/doLogout")
	@ResponseBody
	public String doLogout(HttpServletRequest req) {

		// 로그인 로그아웃때문에 하나 불러와야함
		Rq rq = (Rq) req.getAttribute("rq");

		rq.logout();

		return Ut.jsReplace("S-1", "로그아웃 성공", "/");
	}

	// 회원가입 폼 보여주기
	@RequestMapping("/user/member/join")
	public String showJoin() {
		return "/user/member/join";
	}
	
	// 액션 메서드
	// 회원가입
	@RequestMapping("/user/member/doJoin")
	@ResponseBody
	public ResultData<Member> doJoin(HttpServletRequest req, String loginId, String loginPw, String name,
			String nickname, String email) {

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

	// 로그인 폼 보여주기
	@RequestMapping("/user/member/login")
	public String showLogin() {
		return "/user/member/login";
	}

	// 로그인

	@RequestMapping("/user/member/doLogin")
	@ResponseBody
	public String doLogin(HttpServletRequest req, String loginId, String loginPw) {

		// 아래서 로그인 시켜줘야하기에 필요함
		Rq rq = (Rq) req.getAttribute("rq");

		if (Ut.isEmptyOrNull(loginId)) {
			return Ut.jsHistoryBack("f-1", "아이디를 입력해주세요.");
		}

		if (Ut.isEmptyOrNull(loginPw)) {
			return Ut.jsHistoryBack("f-2", "비밀번호를 입력해주세요.");
		}

		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			return Ut.jsHistoryBack("F-3", Ut.f("%s는(은) 없는 아이디입니다.", loginId));
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return Ut.jsHistoryBack("F-4", "비밀번호가 일치하지 않습니다.");
		}

		rq.login(member);

		return Ut.jsReplace("S-1", Ut.f("%s님 환영합니다.", member.getName()), "/");

	}

}
