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
import com.example.demo.vo.Article;
import com.example.demo.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UserMemberController {

	@Autowired
	private MemberService memberService;

	// 액션 메서드
	@RequestMapping("/user/member/doJoin")
	@ResponseBody
	public Member doJoin(String loginId, String loginPw, String name) {

		int id = memberService.joinMember(loginId, loginPw, name);
		
		Member member = memberService.getMemberById(id);

		return member;
	}

//	@RequestMapping("/user/member/getMembers")
//	@ResponseBody
//	public List<Member> getMembers() {
//
//		return memberService.getMembers();
//	}

}
