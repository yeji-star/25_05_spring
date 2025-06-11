package com.example.demo.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
<<<<<<< HEAD
import lombok.Builder;
=======
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
@Builder
public class Member {

=======
public class Member {

	public Member(String loginId, String loginPw, String name, String nickname, String email) {
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
	}

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	private int id;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	private String loginId;
	private String loginPw;
	private String name;
	private String nickname;
<<<<<<< HEAD
	private String cellphoneNum;
	private String email;
	private boolean delStatus;
	private LocalDateTime delDate;
=======
	private String email;
	private boolean delStatus;
	private LocalDateTime delDate;
	

//	public Article(int id, String title, String body) {
//		this.id = id;
//		this.title = title;
//		this.body = body;
//	}

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
}
