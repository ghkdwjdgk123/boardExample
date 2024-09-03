package com.example.boardproject.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardDao {
    Autowired
    private SqlSession sqlSession;
    private String namespace = "dao.BoardDao";

    
}
