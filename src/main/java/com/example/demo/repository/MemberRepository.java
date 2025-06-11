package com.example.demo.repository;

<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;

=======
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Article;
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
import com.example.demo.vo.Member;

@Mapper
public interface MemberRepository {

<<<<<<< HEAD
	public int doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email);
=======
	public int joinMember(String loginId, String loginPw, String name, String nickname, String email);

//	@Select("SELECT * FROM `member`")
//	public List<Member> getMembers();
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734

	public Member getMemberById(int id);

	public int getLastInsertId();

	public Member getMemberByLoginId(String loginId);

	public Member getMemberByNameAndEmail(String name, String email);
<<<<<<< HEAD

	public void modify(int loginedMemberId, String loginPw, String name, String nickname, String cellphoneNum,
			String email);

	public void modifyWithoutPw(int loginedMemberId, String name, String nickname, String cellphoneNum, String email);

=======
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
}
