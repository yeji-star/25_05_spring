package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.Article;

public class ArticleRepository {
	int lastArticleId;
	public List<Article> articles; // DB연결을 안해놔서 List 임 (새로고침시 사라짐)
	
	public ArticleRepository() {
		articles = new ArrayList<>();
		lastArticleId = 0;
	}

	public Article writeArticle(String title, String body) {
		int id = lastArticleId + 1;
		Article article = new Article(id, title, body);
		articles.add(article);

		lastArticleId++;

		return article;
		
	}

	public void deleteArticle(int id) {
		Article article = getArticleById(id);
		articles.remove(article);
		
	}

	public void modifyArticle(int id, String title, String body) {
		Article article = getArticleById(id);
		article.setTitle(title);
		article.setBody(body);
		
	}

	public Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	public List<Article> getArticles() {
		return articles;
		
	}
	
	
}
