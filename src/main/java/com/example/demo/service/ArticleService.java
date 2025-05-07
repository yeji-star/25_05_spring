package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DemoApplication;
import com.example.demo.dto.Article;
import com.example.demo.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

//	private DemoApplication demoApplication;

	// 생성자
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;

		makeTestData();

//		this.demoApplication = demoApplication;
	}

	// 테스트 데이터 생성
	// 서비스 메서드
	private void makeTestData() {
		for (int i = 1; i < 10; i++) {
			String title = "제목 " + i;
			String body = "내용 " + i;

			articleRepository.writeArticle(title, body);
		}

	}

	public Article writeArticle(String title, String body) {

		return articleRepository.writeArticle(title, body);

	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);

	}

	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);

	}

	// 번호찾기
	public Article getArticleById(int id) {
		return articleRepository.getArticleById(id);
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

}
