package com.example.demo.service;

import com.example.demo.repository.UserQnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQnaService {

    @Autowired
    private UserQnaRepository userQnaRepository;

    public String findAnswerByKeyword(String question) {
        return userQnaRepository.findFaqAnswer(question);
    }
}