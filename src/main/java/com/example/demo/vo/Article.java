package com.example.demo.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {

	public Article(String title, String body) {
		this.title = title;
		this.body = body;
	}

	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private int boardId;
	private String title;
	private String body;
	private int hitCount;
	
	private String extra__writer;
	private String extra__goodPoint;
	private String extra__badPoint;
	private String extra__sumPoint;
	
	private boolean userCanModify;
	private boolean userCanDelete;

//	public Article(int id, String title, String body) {
//		this.id = id;
//		this.title = title;
//		this.body = body;
//	}

}
