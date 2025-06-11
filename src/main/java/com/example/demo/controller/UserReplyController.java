package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Interceptor.BeforeActionInterceptor;
import com.example.demo.service.ArticleService;
import com.example.demo.service.BoardService;
import com.example.demo.service.replyService;
import com.example.demo.service.ReactionPointService;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.Board;
import com.example.demo.vo.Reply;
import com.example.demo.vo.ResultData;
import com.example.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserReplyController {

	@Autowired
	private Rq rq;

	@Autowired
	private ReactionPointService reactionPointService;
	
	@Autowired
	private ArticleService articleService;

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private replyService commentService;

	@RequestMapping("user/writeReply")
	@ResponseBody
	public String writeReply(HttpServletRequest req, String relTypeCode, String body, int relId) {
		
		Rq rq = (Rq) req.getAttribute("rq");

		if (Ut.isEmptyOrNull(body)) {
			return Ut.jsHistoryBack("F-1", "내용을 입력하세요.");
		}

		ResultData doWriteReplyRd = commentService.writeReply(rq.getLoginedMemberId(), relTypeCode, body, relId);

		int id = (int) doWriteReplyRd.getData1();

		Board board = boardService.getBoardById(relId);
		
		

		return Ut.jsReplace(doWriteReplyRd.getResultCode(), doWriteReplyRd.getMsg(), "../article/detail?id=" + id);
	}

	
	@RequestMapping("user/reply/reactionPoint/doGoodReaction")
	@ResponseBody
	public ResultData replyDoGoodReaction(String relTypeCode, int relId, String replaceUri) {

		// 로그인한놈을 알고 (rq 에 잇음) 어디에 잇나 알고, 누구인지 알고
		ResultData usersReactionRd = reactionPointService.usersReaction(rq.getLoginedMemberId(), relTypeCode, relId);

		int usersReaction = (int) usersReactionRd.getData1();

		if (usersReaction == 1) {
			ResultData rd = reactionPointService.deleteGoodReactionPoint(rq.getLoginedMemberId(), relTypeCode, relId);
			int goodRP = articleService.getGoodRP(relId);
			int badRP = articleService.getBadRP(relId);
			return ResultData.from("S-1", "좋아요 취소", "goodRP", goodRP, "badRP", badRP);

		} else if (usersReaction == -1) {
			ResultData rd = reactionPointService.deleteBadReactionPoint(rq.getLoginedMemberId(), relTypeCode, relId);

			rd = reactionPointService.addGoodReactionPoint(rq.getLoginedMemberId(), relTypeCode, relId);

			int goodRP = articleService.getGoodRP(relId);
			int badRP = articleService.getBadRP(relId);
			return ResultData.from("S-2", "싫어요 했었음", "goodRP", goodRP, "badRP", badRP);
		}

		ResultData reactionRd = reactionPointService.addGoodReactionPoint(rq.getLoginedMemberId(), relTypeCode, relId);

		if (reactionRd.isfail()) {
			return ResultData.from(reactionRd.getResultCode(), reactionRd.getMsg());
		}

		int goodRP = articleService.getGoodRP(relId);
		int badRP = articleService.getBadRP(relId);
		return ResultData.from("S-1", "좋아요 취소", "goodRP", goodRP, "badRP", badRP);
	}

}
