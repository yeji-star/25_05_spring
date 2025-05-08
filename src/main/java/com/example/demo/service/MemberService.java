package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MemberRepository;
import com.example.demo.vo.Article;
import com.example.demo.vo.Member;

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

	public int joinMember(String loginId, String loginPw, String name, String email) {

		Member existsMember = getMemberByLoginId(loginId);
		System.out.println("existsMember: " + existsMember);

		

		if (existsMember != null) {
			return -1;
		}
		
		existsMember = getMemberByNameAndEmail(name, email);
		
		if (existsMember != null) {
			return -2;
		}

		memberRepository.joinMember(loginId, loginPw, name, email);
		return memberRepository.getLastInsertId();
	}

	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberNameByEmail(name, email);
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
