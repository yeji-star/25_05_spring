package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.replyRepository;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.Reply;
import com.example.demo.vo.ResultData;

@Service
public class replyService {

	@Autowired
	private replyRepository commentRepository;

	public replyService(replyRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public ResultData writeReply(int loginedMemberId, String relTypeCode, String body, int relId) {
		commentRepository.writeReply(loginedMemberId, relTypeCode ,body, relId);

		return ResultData.from("S-1", "댓글이 등록되었습니다.");
	}

	public Reply getCommentById(int boardId) {

		return commentRepository.getCommentById(boardId);

	}

}
