package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.DemoApplication;
import com.example.demo.service.ArticleService;
import com.example.demo.vo.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UserArticleController {

	@Autowired
	private ArticleService articleService;

	// id, title, body로 이루어진 게시글 객체 1개 생성
	// 액션 메서드
	@RequestMapping("/user/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {

		Article article = articleService.writeArticle(title, body);

		return article;
	}

	// 생성(doAdd)했던 게시글'들' 출력

	@RequestMapping("/user/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {

		return articleService.getArticles();
	}

	// 단일 글만 보고 싶을 때

	@RequestMapping("/user/article/getArticle")
	@ResponseBody
	public Object getArticle(int id) {

		Article article = articleService.getArticleById(id);

		if (article == null) {
			return id + "번 글은 없습니다.";
		}

		return article;
	}

	// 데이터 삭제

	@RequestMapping("/user/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {

		Article article = articleService.getArticleById(id);

		if (article == null) {
			return id + "번 글은 없습니다.";
		}

		articleService.deleteArticle(id);

		return id + "번 글이 삭제되었습니다.";
	}

	// 글 수정

	@RequestMapping("/user/article/doModify")
	@ResponseBody
	public Object doModify(int id, String title, String body) {

		System.out.println("id" + id);
		System.out.println("title " + title);
		System.out.println("body " + body);

		Article article = articleService.getArticleById(id);

		if (article == null) {
			return id + "번 글은 없습니다.";
		}

		articleService.modifyArticle(id, title, body);

		return article;
	}

}
