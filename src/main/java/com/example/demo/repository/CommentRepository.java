package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.Article;
import com.example.demo.vo.Comment;

@Mapper
public interface CommentRepository {

	Comment getCommentById(int boardId);

	void writeComment(int loginedMemberId, String text, int boardId);



}
