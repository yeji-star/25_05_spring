package com.example.demo.service;

<<<<<<< HEAD
=======
import java.sql.ResultSet;
import java.util.ArrayList;
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import com.example.demo.DemoApplication;
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
import com.example.demo.repository.ArticleRepository;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.ResultData;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

<<<<<<< HEAD
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public ResultData writeArticle(int memberId, String title, String body, String boardId) {
		articleRepository.writeArticle(memberId, title, body, boardId);

		int id = articleRepository.getLastInsertId();

		return ResultData.from("S-1", Ut.f("%d번 글이 등록되었습니다", id), "등록 된 게시글 id", id);
=======
	// 생성자
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;

	}

	public ResultData writeArticle(int memberId, String title, String body, String boardId) {

		articleRepository.writeArticle(memberId, title, body, boardId);
		int id = articleRepository.getLastInsertId();

		return ResultData.from("S-1", Ut.f("%d번 글이 등록되었습니다", id), "등록된 게시글 id", id);

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
<<<<<<< HEAD
=======

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	}

	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
<<<<<<< HEAD
=======

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	}

	public ResultData userCanModify(int loginedMemberId, Article article) {

		if (article.getMemberId() != loginedMemberId) {
<<<<<<< HEAD
			return ResultData.from("F-A", Ut.f("%d번 게시글에 대한 수정 권한 없음", article.getId()));
		}

		return ResultData.from("S-1", Ut.f("%d번 게시글 수정 가능", article.getId()));
	}

	public ResultData userCanDelete(int loginedMemberId, Article article) {
		if (article.getMemberId() != loginedMemberId) {
			return ResultData.from("F-A", Ut.f("%d번 게시글에 대한 삭제 권한 없음", article.getId()));
		}

		return ResultData.from("S-1", Ut.f("%d번 게시글 삭제 가능", article.getId()));
	}

	public Article getForPrintArticle(int loginedMemberId, int id) {

		Article article = articleRepository.getForPrintArticle(id);

		controlForPrintData(loginedMemberId, article);

		return article;
	}

	private void controlForPrintData(int loginedMemberId, Article article) {
		if (article == null) {
			return;
		}

		ResultData userCanModifyRd = userCanModify(loginedMemberId, article);
		article.setUserCanModify(userCanModifyRd.isSuccess());

		ResultData userDeleteRd = userCanDelete(loginedMemberId, article);
		article.setUserCanDelete(userDeleteRd.isSuccess());
	}

=======
			return ResultData.from("F-A", Ut.f("%d번 게시글에 대한 수정 권한이 없습니다.", article.getId()));
		}

		return ResultData.from("S-1", Ut.f("%d번 게시글의 수정이 가능합니다.", article.getId()));
	}

	public ResultData userCanDelete(int loginedMemberId, Article article) {

		if (article.getMemberId() != loginedMemberId) {
			return ResultData.from("F-A", Ut.f("%d번 게시글에 대한 삭제 권한이 없습니다.", article.getId()));
		}

		return ResultData.from("S-1", Ut.f("%d번 게시글의 삭제가 가능합니다.", article.getId()));
	}

	// 번호찾기
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	public Article getArticleById(int id) {
		return articleRepository.getArticleById(id);
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

<<<<<<< HEAD
	public List<Article> getForPrintArticles(int boardId, int itemsInAPage, int page, String searchKeywordTypeCode,
			String searchKeyword) {
		// SELECT * FROM article WHERE boardId = 1 ORDER BY id DESC LIMIT 0, 10;
		// --> 1page
		// SELECT * FROM article WHERE boardId = 1 ORDER BY id DESC LIMIT 10, 10;
		// --> 2page

		int limitFrom = (page - 1) * itemsInAPage;
		int limitTake = itemsInAPage;

		return articleRepository.getForPrintArticles(boardId, limitFrom, limitTake, searchKeywordTypeCode,
				searchKeyword);
	}

	public int getArticleCount(int boardId, String searchKeywordTypeCode, String searchKeyword) {
		return articleRepository.getArticleCount(boardId, searchKeywordTypeCode, searchKeyword);
	}

	public ResultData increaseHitCount(int id) {
		int affectedRow = articleRepository.increaseHitCount(id);

		if (affectedRow == 0) {
			return ResultData.from("F-1", "해당 게시글 없음", "id", id);
		}

		return ResultData.from("S-1", "조회수 증가", "id", id);
	}

	public Object getArticleHitCount(int id) {
=======
	public Article getForPrintArticle(int loginedMemberId, int id) {
		Article article = articleRepository.getForPrintArticle(id);

		controllForPrintData(loginedMemberId, article);

		return article;
	}

	private void controllForPrintData(int loginedMemberId, Article article) {
		if (article == null) {
			return;
		}

		ResultData userCanModifyRd = userCanModify(loginedMemberId, article);

		article.setUserCanModify(userCanModifyRd.isSuccess());

		ResultData userCanDeleteRd = userCanDelete(loginedMemberId, article);

		article.setUserCanDelete(userCanDeleteRd.isSuccess());

	}

	public List<Article> getForPrintArticles(int boardId, int itemsInAPage, int page, String searchKeywordTypeCode, String searchKeyword) {
		
		int limitFrom = (page - 1) * itemsInAPage;
		int limitTake = itemsInAPage;
		
		return articleRepository.getForPrintArticles(boardId, limitFrom, limitTake, searchKeywordTypeCode, searchKeyword);
	}

	public int getTotalCnt() {
		return articleRepository.getTotalCnt();
	}

	public int getArticlesCount(int boardId, String searchKeywordTypeCode, String searchKeyword) {
		return articleRepository.getArticlesCount(boardId, searchKeywordTypeCode, searchKeyword);
	}

	public ResultData increaseHitCount(int id) {
		// 몇열에 적용됨
		int affectedRow = articleRepository.increaseHitCount(id);
		
		if(affectedRow == 0) {
			return ResultData.from("F-1", "해당 게시글 없음", "id", id);
		}
		
		return ResultData.from("S-1", "조회수 증가", "id", id);
		
	}

	public Object getArticleHitCount(int id) {
		
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
		return articleRepository.getArticleHitCount(id);
	}

	public ResultData increaseGoodReactionPoint(int relId) {
		int affectedRow = articleRepository.increaseGoodReactionPoint(relId);
<<<<<<< HEAD

		if (affectedRow == 0) {
			return ResultData.from("F-1", "없는 게시물");
		}

		return ResultData.from("S-1", "좋아요 증가", "affectedRow", affectedRow);
=======
		
		if(affectedRow == 0) {
			return ResultData.from("F-1", "없는 게시물");
		}
		
		return ResultData.from("S-1", "좋아요 증가", "affectedRow", affectedRow);
		
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	}

	public ResultData increaseBadReactionPoint(int relId) {
		int affectedRow = articleRepository.increaseBadReactionPoint(relId);
<<<<<<< HEAD

		if (affectedRow == 0) {
			return ResultData.from("F-1", "없는 게시물");
		}

		return ResultData.from("S-1", "싫어요 증가", "affectedRow", affectedRow);
	}

	public ResultData decreaseGoodReactionPoint(int relId) {
		int affectedRow = articleRepository.decreaseGoodReactionPoint(relId);

		if (affectedRow == 0) {
			return ResultData.from("F-1", "없는 게시물");
		}

		return ResultData.from("S-1", "좋아요 감소", "affectedRow", affectedRow);
	}

	public ResultData decreaseBadReactionPoint(int relId) {
		int affectedRow = articleRepository.decreaseBadReactionPoint(relId);

		if (affectedRow == 0) {
			return ResultData.from("F-1", "없는 게시물");
		}

		return ResultData.from("S-1", "싫어요 감소", "affectedRow", affectedRow);
	}
=======
		
		if(affectedRow == 0) {
			return ResultData.from("F-1", "없는 게시물");
		}
		
		return ResultData.from("S-1", "싫어요 증가", "affectedRow", affectedRow);
		
	}

	public ResultData decreaseGoodReactionPoint(int relId) {
		
int affectedRow = articleRepository.decreaseGoodReactionPoint(relId);
		
		if(affectedRow == 0) {
			return ResultData.from("F-1", "없는 게시물");
		}
		
		return ResultData.from("S-1", "좋아요 감소", "affectedRow", affectedRow);
	}
	
	public ResultData decreaseBadReactionPoint(int relId) {
		
		int affectedRow = articleRepository.decreaseBadReactionPoint(relId);
				
				if(affectedRow == 0) {
					return ResultData.from("F-1", "없는 게시물");
				}
				
				return ResultData.from("S-1", "싫어요 감소", "affectedRow", affectedRow);
			}
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734

	public int getGoodRP(int relId) {
		return articleRepository.getGoodRP(relId);
	}

	public int getBadRP(int relId) {
		return articleRepository.getBadRP(relId);
	}

<<<<<<< HEAD
=======


>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
}
