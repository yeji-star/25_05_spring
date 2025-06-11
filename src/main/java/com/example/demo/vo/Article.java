package com.example.demo.vo;

<<<<<<< HEAD
=======
import java.time.LocalDateTime;

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {

<<<<<<< HEAD
=======
	public Article(String title, String body) {
		this.title = title;
		this.body = body;
	}

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private int boardId;
	private String title;
	private String body;
	private int hitCount;
	private int goodReactionPoint;
	private int badReactionPoint;
<<<<<<< HEAD

	private String extra__writer;
	
	private String extra__repliesCount;
	
	private String extra__sumReactionPoint;
	
	
	private boolean userCanModify;
	private boolean userCanDelete;
=======
	
	private String extra__writer;
	private String extra__sumPoint;
	
	private boolean userCanModify;
	private boolean userCanDelete;
	
	

//	public Article(int id, String title, String body) {
//		this.id = id;
//		this.title = title;
//		this.body = body;
//	}

>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
}
