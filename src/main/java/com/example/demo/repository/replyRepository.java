package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.Article;
import com.example.demo.vo.Reply;

@Mapper
public interface replyRepository {

	Reply getCommentById(int boardId);

	void writeReply(int loginedMemberId, String relTypeCode, String body, int relId);



}
