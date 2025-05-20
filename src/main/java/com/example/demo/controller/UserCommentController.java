package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Interceptor.BeforeActionInterceptor;
import com.example.demo.service.ArticleService;
import com.example.demo.service.BoardService;
import com.example.demo.service.CommentService;
import com.example.demo.service.ReactionPointService;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.Board;
import com.example.demo.vo.Comment;
import com.example.demo.vo.ResultData;
import com.example.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserCommentController {

	@Autowired
	private Rq rq;

	@Autowired
	private ReactionPointService reactionPointService;

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService commentService;

	@RequestMapping("user/writeComment")
	@ResponseBody
	public String writeComment(HttpServletRequest req, String text, int boardId) {
		
		Rq rq = (Rq) req.getAttribute("rq");


		if (Ut.isEmptyOrNull(text)) {
			return Ut.jsHistoryBack("F-1", "내용을 입력하세요.");
		}

		ResultData doWriteRd = commentService.writeComment(rq.getLoginedMemberId(), text, boardId);

		int id = (int) doWriteRd.getData1();

		Board board = boardService.getBoardById(boardId);
		
		

		return Ut.jsReplace(doWriteRd.getResultCode(), doWriteRd.getMsg(), "../article/detail?id=" + id);
	}


}
