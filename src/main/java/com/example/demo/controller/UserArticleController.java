package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UserArticleController {

	int lastArticleId;
	List<Article> articles;

	// DB연결을 안해놔서 List 임 (새로고침시 사라짐)
	
	public UserArticleController() {
		articles = new ArrayList<>();
		lastArticleId = 0;
	}

	// id, title, body로 이루어진 게시글 객체 1개 생성

	@RequestMapping("/user/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {

		int id = lastArticleId + 1;
		Article article = new Article(id, title, body);
		lastArticleId++;

		return article;
	}

	// 생성(doAdd)했던 게시글'들' 출력

	@RequestMapping("/user/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {

		return articles;
	}

}
