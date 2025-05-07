package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.DemoApplication;
import com.example.demo.dto.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UserArticleController {

	private final DemoApplication demoApplication;

	int lastArticleId;
	List<Article> articles; // DB연결을 안해놔서 List 임 (새로고침시 사라짐)

	// 생성자
	public UserArticleController(DemoApplication demoApplication) {
		articles = new ArrayList<>();
		lastArticleId = 0;

		makeTestData();

		this.demoApplication = demoApplication;
	}

	// 테스트 데이터 생성
	// 서비스 메서드
	private void makeTestData() {
		for (int i = 1; i < 10; i++) {
			String title = "제목 " + i;
			String body = "내용 " + i;

			writeArticle(title, body);
		}

	}

	private Article writeArticle(String title, String body) {
		int id = lastArticleId + 1;
		Article article = new Article(id, title, body);
		articles.add(article);

		lastArticleId++;

		return article;

	}

	/////////////////////

	// id, title, body로 이루어진 게시글 객체 1개 생성
	// 액션 메서드
	@RequestMapping("/user/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {

		Article article = writeArticle(title, body);

		return article;
	}

	// 생성(doAdd)했던 게시글'들' 출력

	@RequestMapping("/user/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {

		return articles;
	}


	//번호찾기
	private Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	// 데이터 삭제
	
	@RequestMapping("/user/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {

		Article article = getArticleById(id);
		
		if(article == null) {
			return id + "번 글은 없습니다.";
		}

		articles.remove(article);

		return id + "번 글이 삭제되었습니다.";
	}

	// 글 수정

	@RequestMapping("/user/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {

		Article article = getArticleById(id);
		
		if(article == null) {
			return id + "번 글은 없습니다.";
		}

		article.setTitle(title);
		article.setBody(body);

		return id + "번 글이 수정되었습니다. " + article;
	}

}
