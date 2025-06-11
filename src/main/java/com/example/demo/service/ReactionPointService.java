package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.BoardRepository;
<<<<<<< HEAD
import com.example.demo.repository.ReactionPointRepository;
=======
import com.example.demo.repository.ReactionRepository;
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
import com.example.demo.vo.Board;
import com.example.demo.vo.ResultData;

@Service
public class ReactionPointService {
<<<<<<< HEAD

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ReactionPointRepository reactionPointRepository;

	public ReactionPointService(ReactionPointRepository reactionPointRepository) {
		this.reactionPointRepository = reactionPointRepository;
	}

	public ResultData usersReaction(int loginedMemberId, String relTypeCode, int relId) {

		if (loginedMemberId == 0) {
			return ResultData.from("F-L", "로그인 하고 써야해");
		}

		int sumReactionPointByMemberId = reactionPointRepository.getSumReactionPoint(loginedMemberId, relTypeCode,
				relId);

		if (sumReactionPointByMemberId != 0) {
			return ResultData.from("F-1", "추천 불가능", "sumReactionPointByMemberId", sumReactionPointByMemberId);
		}

=======
    
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ReactionRepository reactionRepository;

	public ReactionPointService(ReactionRepository reactionRepository) {
		this.reactionRepository = reactionRepository;

	}

	public ResultData usersReaction(int loginedMemberId, String relTypeCode, int relId) {
		
		// 로그인 안했음
		if(loginedMemberId == 0) {
			return ResultData.from("F-L", "로그인 하세요.");
		}
		
		int sumReactionPointByMemberId = reactionRepository.getSumReactionPoint(loginedMemberId, relTypeCode, relId);
		
		if(sumReactionPointByMemberId != 0) {
			return ResultData.from("F-1", "추천 불가능", "sumReactionPointByMemberId", sumReactionPointByMemberId);
		}
				
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
		return ResultData.from("S-1", "추천 가능", "sumReactionPointByMemberId", sumReactionPointByMemberId);
	}

	public ResultData addGoodReactionPoint(int loginedMemberId, String relTypeCode, int relId) {
<<<<<<< HEAD

		int affectedRow = reactionPointRepository.addGoodReactionPoint(loginedMemberId, relTypeCode, relId);

		if (affectedRow != 1) {
			return ResultData.from("F-1", "좋아요 실패");
		}

=======
		
		int affectedRow = reactionRepository.addGoodReactionPoint(loginedMemberId, relTypeCode, relId);
		
		if(affectedRow != 1) {
			return ResultData.from("F-1", "좋아요 실패");
		}
		
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
		switch (relTypeCode) {
		case "article":
			articleService.increaseGoodReactionPoint(relId);
			break;
		}
<<<<<<< HEAD

		return ResultData.from("S-1", "좋아요!");
	}

	public ResultData addBadReactionPoint(int loginedMemberId, String relTypeCode, int relId) {
		int affectedRow = reactionPointRepository.addBadReactionPoint(loginedMemberId, relTypeCode, relId);

		if (affectedRow != 1) {
			return ResultData.from("F-1", "싫어요 실패");
		}

=======
		
		return ResultData.from("S-1", "좋아요");
	}

	public ResultData addBadReactionPoint(int loginedMemberId, String relTypeCode, int relId) {
		
		int affectRow = reactionRepository.addBadReactionPoint(loginedMemberId, relTypeCode, relId);
		
		if(affectRow != 1) {
			return ResultData.from("F-1", "싫어요 실패");
		}
		
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
		switch (relTypeCode) {
		case "article":
			articleService.increaseBadReactionPoint(relId);
			break;
		}
<<<<<<< HEAD

		return ResultData.from("S-1", "싫어요!");
	}

	public ResultData deleteGoodReactionPoint(int loginedMemberId, String relTypeCode, int relId) {
		reactionPointRepository.deleteReactionPoint(loginedMemberId, relTypeCode, relId);

		switch (relTypeCode) {
=======
		
		return ResultData.from("S-1", "싫어요");
	}

	public ResultData deleteGoodReactionPoint(int loginedMemberId, String relTypeCode, int relId) {
		reactionRepository.deleteReactionPoint(loginedMemberId, relTypeCode, relId);
		
		switch(relTypeCode) {
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
		case "article":
			articleService.decreaseGoodReactionPoint(relId);
			break;
		}
<<<<<<< HEAD
		return ResultData.from("S-1", "좋아요 취소 됨");

	}

	public ResultData deleteBadReactionPoint(int loginedMemberId, String relTypeCode, int relId) {
		reactionPointRepository.deleteReactionPoint(loginedMemberId, relTypeCode, relId);

		switch (relTypeCode) {
=======
		return ResultData.from("S-1", "좋아요 취소됨");
	}
	
	public ResultData deleteBadReactionPoint(int loginedMemberId, String relTypeCode, int relId) {
		reactionRepository.deleteReactionPoint(loginedMemberId, relTypeCode, relId);
		
		switch(relTypeCode) {
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
		case "article":
			articleService.decreaseBadReactionPoint(relId);
			break;
		}
<<<<<<< HEAD
		return ResultData.from("S-1", "싫어요 취소 됨");
	}

	public boolean isAlreadyAddGoodRp(int memberId, int relId, String relTypeCode) {
		int getPointTypeCodeByMemberId = reactionPointRepository.getSumReactionPoint(memberId, relTypeCode, relId);

		if (getPointTypeCodeByMemberId > 0) {
			return true;
		}

		return false;
	}

	public boolean isAlreadyAddBadRp(int memberId, int relId, String relTypeCode) {
		int getPointTypeCodeByMemberId = reactionPointRepository.getSumReactionPoint(memberId, relTypeCode, relId);

		if (getPointTypeCodeByMemberId < 0) {
			return true;
		}

		return false;
	}

}
=======
		return ResultData.from("S-1", "싫어요 취소됨");
	}

	public boolean isAlreadyAddGoodRp(int memberId, int relid, String relTypeCode) {
		int getPointTypeCodeByMemberId = reactionRepository.getSumReactionPoint(memberId, relTypeCode, relid);
		
		if(getPointTypeCodeByMemberId > 0) {
			return true;
		}
		return false;
	}

	public boolean isAlreadyAddBadRp(int memberId, int relid, String relTypeCode) {
		int getPointTypeCodeByMemberId = reactionRepository.getSumReactionPoint(memberId, relTypeCode, relid);
		
		if(getPointTypeCodeByMemberId > 0) {
			return true;
		}
		return false;
	}
	
}
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
