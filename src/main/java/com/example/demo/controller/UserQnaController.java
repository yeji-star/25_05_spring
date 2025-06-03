package com.example.demo.controller;

import com.example.demo.service.UserQnaService;
import com.example.demo.vo.ResultData;
import com.example.demo.vo.Rq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserQnaController {

    @Autowired
    private UserQnaService userQnaService;

    @Autowired
    private Rq rq;

    @PostMapping("/user/faq/ask")
    @ResponseBody
    public ResultData<String> ask(@RequestParam String question) {
        String answer = userQnaService.findAnswerByKeyword(question);

        if (answer == null) {
            return ResultData.from("F-1", "해당 질문에 대한 답변을 찾을 수 없습니다.");
        }

        return ResultData.from("S-1", "답변이 성공적으로 조회되었습니다.", "answer", answer);
    }

    @GetMapping("/user/faq/faq")
    public String showFaqPage() {
        return "/user/faq/faq";
    }
}