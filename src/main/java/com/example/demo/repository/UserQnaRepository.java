package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserQnaRepository {
    String findFaqAnswer(String question);
}