package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Article;
import com.example.demo.vo.Member;

@Mapper
public interface MemberRepository {

	public int joinMember(String loginId, String loginPw, String name, String nickname, String email);

//	@Select("SELECT * FROM `member`")
//	public List<Member> getMembers();

	public Member getMemberById(int id);

	public int getLastInsertId();

	public Member getMemberByLoginId(String loginId);

	public Member getMemberByNameAndEmail(String name, String email);
}
