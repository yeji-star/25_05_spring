package com.example.demo.repository;

<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;

=======
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.example.demo.vo.Article;
>>>>>>> 6b94bad872319c3c208baea6753132270d9b8734
import com.example.demo.vo.Board;

@Mapper
public interface BoardRepository {

	public Board getBoardById(int id);

}
