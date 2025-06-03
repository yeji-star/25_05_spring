package com.example.demo.vo;

import lombok.Data;

@Data
public class Qna {
    private int id;
    private String regDate;
    private String title;
    private String question;
    private String answer;
}