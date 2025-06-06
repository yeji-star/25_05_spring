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
public class Reply {

	private int id;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	private int userId;
	private int boardId;
	private String text;
	private boolean delStatus;
	
}
