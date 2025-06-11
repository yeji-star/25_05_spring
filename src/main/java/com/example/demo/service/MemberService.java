package com.example.demo.service;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
import org.springframework.stereotype.Service;

import com.example.demo.repository.MemberRepository;
import com.example.demo.util.Ut;
<<<<<<< HEAD
=======
import com.example.demo.vo.Article;
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
import com.example.demo.vo.Member;
import com.example.demo.vo.ResultData;

@Service
public class MemberService {

<<<<<<< HEAD
	@Value("${custom.siteMainUri}")
	private String siteMainUri;
	@Value("${custom.siteName}")
	private String siteName;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MailService mailService;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public ResultData notifyTempLoginPwByEmail(Member actor) {
		String title = "[" + siteName + "] 임시 패스워드 발송";
		String tempPassword = Ut.getTempPassword(6);
		String body = "<h1>임시 패스워드 : " + tempPassword + "</h1>";
		body += "<a href=\"" + siteMainUri + "/usr/member/login\" target=\"_blank\">로그인 하러가기</a>";

		ResultData sendResultData = mailService.send(actor.getEmail(), title, body);

		if (sendResultData.isFail()) {
			return sendResultData;
		}

		setTempPassword(actor, tempPassword);

		return ResultData.from("S-1", "계정의 이메일주소로 임시 패스워드가 발송되었습니다.");
	}

	private void setTempPassword(Member actor, String tempPassword) {
		memberRepository.modify(actor.getId(), Ut.sha256(tempPassword), null, null, null, null);
	}

	public ResultData<Integer> join(String loginId, String loginPw, String name, String nickname, String cellphoneNum,
			String email) {

		Member existsMember = getMemberByLoginId(loginId);
=======
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

	public ResultData<Integer> join(String loginId, String loginPw, String name, String nickname, String email) {

		Member existsMember = getMemberByLoginId(loginId);
		System.out.println("existsMember: " + existsMember);
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734

		if (existsMember != null) {
			return ResultData.from("F-7", Ut.f("이미 사용중인 아이디(%s)입니다", loginId));
		}

		existsMember = getMemberByNameAndEmail(name, email);

		if (existsMember != null) {
			return ResultData.from("F-8", Ut.f("이미 사용중인 이름(%s)과 이메일(%s)입니다", name, email));
		}

<<<<<<< HEAD
		loginPw = Ut.sha256(loginPw);

		memberRepository.doJoin(loginId, loginPw, name, nickname, cellphoneNum, email);

		int id = memberRepository.getLastInsertId();

		return ResultData.from("S-1", "회원가입 성공", "가입 성공 id", id);
	}

	public Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);

	}

	public Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
=======
		memberRepository.joinMember(loginId, loginPw, name, nickname, email);

		int id = memberRepository.getLastInsertId();

		return ResultData.from("s-1", "회원가입 성공", "가입 성공 id", id);
	}

	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}

<<<<<<< HEAD
	public ResultData modify(int loginedMemberId, String loginPw, String name, String nickname, String cellphoneNum,
			String email) {

		loginPw = Ut.sha256(loginPw);

		memberRepository.modify(loginedMemberId, loginPw, name, nickname, cellphoneNum, email);

		return ResultData.from("S-1", "회원정보 수정 완료");
	}

	public ResultData modifyWithoutPw(int loginedMemberId, String name, String nickname, String cellphoneNum,
			String email) {
		memberRepository.modifyWithoutPw(loginedMemberId, name, nickname, cellphoneNum, email);

		return ResultData.from("S-1", "회원정보 수정 완료");
=======
	public Member getMemberByLoginId(String loginId) {

		return memberRepository.getMemberByLoginId(loginId);
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	}

}
