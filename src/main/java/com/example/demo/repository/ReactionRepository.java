package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReactionRepository {

	public int getSumReactionPoint(int memberId, String relTypeCode, int relId);

//	int increaseReactionPoint(int loginedMemberId, String relTypeCode, int relId);
//
//	int decreaseReactionPoint(int loginedMemberId, String relTypeCode, int relId);

	public int addGoodReactionPoint(int memberId, String relTypeCode, int relId);

	public int addBadReactionPoint(int memberId, String relTypeCode, int relId);

	public void deleteReactionPoint(int memberId, String relTypeCode, int relId);

}
