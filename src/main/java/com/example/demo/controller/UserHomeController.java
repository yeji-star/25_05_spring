package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UserHomeController {
	

	@RequestMapping("/user/home/getInt")
	@ResponseBody
	public int getInt() {		
		return 1;
	}
	
	@RequestMapping("/user/home/getString")
	@ResponseBody
	public String getString() {		
		return "abc";
	}

	@RequestMapping("/user/home/getBoo")
	@ResponseBody
	public boolean getBoo() {		
		return true;
	}
	
	@RequestMapping("/user/home/getDou")
	@ResponseBody
	public double getDou() {		
		return 3.14;
	}
	
	@RequestMapping("/user/home/getMap")
	@ResponseBody
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("철수 나이", 11);
		return map;
	}
	
	@RequestMapping("/user/home/getList")
	@ResponseBody
	public List<String> getList() {
		List<String> list = new ArrayList<>();
		list.add("철수 나이");
		
		return list;
	}
	
	@RequestMapping("/user/home/getArticle")
	@ResponseBody
	public Article getArticle() {
		Article article = new Article(1, "제목1", "내용1");
		
		
		return article;
	}
	
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Article {
	int id;
	String title;
	String body;
	
//	public Article(int id, String title, String body) {
//		this.id = id;
//		this.title = title;
//		this.body = body;
//	}
	
}