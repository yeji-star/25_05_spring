package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.Comment;
import com.example.demo.vo.ResultData;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public ResultData writeComment(int loginedMemberId, String text, int boardId) {
		commentRepository.writeComment(loginedMemberId, text, boardId);

		return ResultData.from("S-1", "댓글이 등록되었습니다.");
	}

	public Comment getCommentById(int boardId) {

		return commentRepository.getCommentById(boardId);

	}

}
