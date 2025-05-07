package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DemoApplication;
import com.example.demo.dto.Article;

@Service
public class ArticleService {
	
	int lastArticleId;
	public List<Article> articles; // DB연결을 안해놔서 List 임 (새로고침시 사라짐)
//	private DemoApplication demoApplication;

	// 생성자
	public ArticleService() {
		articles = new ArrayList<>();
		lastArticleId = 0;

		makeTestData();

//		this.demoApplication = demoApplication;
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

	public Article writeArticle(String title, String body) {
		int id = lastArticleId + 1;
		Article article = new Article(id, title, body);
		articles.add(article);

		lastArticleId++;

		return article;

	}

	// 번호찾기
	public Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	public void modifyArticle(int id, String title, String body) {
		Article article = getArticleById(id);
		article.setTitle(title);
		article.setBody(body);
		
	}

	public void deleteArticle(int id) {
		Article article = getArticleById(id);
		articles.remove(article);
		
	}
}
