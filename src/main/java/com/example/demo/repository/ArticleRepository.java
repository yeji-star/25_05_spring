package com.example.demo.repository;

<<<<<<< HEAD
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
=======
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734

import com.example.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	public int writeArticle(int memberId, String title, String body, String boardId);

	public void deleteArticle(int id);

	public void modifyArticle(int id, String title, String body);

<<<<<<< HEAD
	public int getLastInsertId();

=======
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	public Article getArticleById(int id);

	public List<Article> getArticles();

<<<<<<< HEAD
=======
	public int getLastInsertId();

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	public Article getForPrintArticle(int loginedMemberId);

	public List<Article> getForPrintArticles(int boardId, int limitFrom, int limitTake, String searchKeywordTypeCode,
			String searchKeyword);

<<<<<<< HEAD
	public int getArticleCount(int boardId, String searchKeywordTypeCode, String searchKeyword);
=======
	public int getTotalCnt();

	public int getArticlesCount(int boardId, String searchKeywordTypeCode, String searchKeyword);
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734

	public int increaseHitCount(int id);

	public int getArticleHitCount(int id);

	public int increaseGoodReactionPoint(int relId);

	public int decreaseGoodReactionPoint(int relId);
<<<<<<< HEAD

=======
	
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	public int increaseBadReactionPoint(int relId);

	public int decreaseBadReactionPoint(int relId);

	public int getGoodRP(int relId);

	public int getBadRP(int relId);
<<<<<<< HEAD
=======
	
	

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
}
