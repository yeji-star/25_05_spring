package com.example.demo.vo;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
=======
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
public class Reply {

	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private String relTypeCode;
	private int relId;
	private String body;
	private int goodReactionPoint;
	private int badReactionPoint;

	private String extra__writer;

	private String extra__sumReactionPoint;

	private boolean userCanModify;
	private boolean userCanDelete;

}
=======
@Builder
public class Reply {

	private int id;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	private int userId;
	private int boardId;
	private String text;
	private boolean delStatus;
	
}
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
