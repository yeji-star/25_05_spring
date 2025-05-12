package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MemberRepository;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.Member;
import com.example.demo.vo.ResultData;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;

//		makeTestData();
	}

	// 테스트 데이터 생성
	// 서비스 메서드
//	private void makeTestData() {
//		for (int i = 1; i < 5; i++) {
//			String loginId = "user" + i;
//			String loginPw = "user" + i;
//			String name = "user" + i;
//
//			memberRepository.joinMember(loginId, loginPw, name);
//		}
//
//	}

	public ResultData<Integer> joinMember(String loginId, String loginPw, String name, String nickname, String email) {

		Member existsMember = getMemberByLoginId(loginId);
		System.out.println("existsMember: " + existsMember);

		if (existsMember != null) {
			return ResultData.from("F-7", Ut.f("이미 사용중인 아이디(%s)입니다", loginId));
		}

		existsMember = getMemberByNameAndEmail(name, email);

		if (existsMember != null) {
			return ResultData.from("F-8", Ut.f("이미 사용중인 이름(%s)과 이메일(%s)입니다", name, email));
		}

		memberRepository.joinMember(loginId, loginPw, name, nickname, email);

		int id = memberRepository.getLastInsertId();

		return ResultData.from("s-1", "회원가입 성공", "가입 성공 id", id);
	}

	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}

//	public List<Member> getMembers() {
//		return memberRepository.getMembers();
//	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}

	public Member getMemberByLoginId(String loginId) {

		return memberRepository.getMemberByLoginId(loginId);
	}

}
