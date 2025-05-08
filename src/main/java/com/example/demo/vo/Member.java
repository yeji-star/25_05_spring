package com.example.demo.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	public Member(String loginId, String loginPw, String name, String email) {
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.name = name;
		this.email = email;
	}

	private int id;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	private String loginId;
	private String loginPw;
	private String name;
	private String email;

//	public Article(int id, String title, String body) {
//		this.id = id;
//		this.title = title;
//		this.body = body;
//	}

}
