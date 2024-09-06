package com.example.boardproject.board.dao;

import com.example.boardproject.board.domain.BoardDto;
import com.example.boardproject.board.entity.PageHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {
    @Autowired
    SqlSession sqlSession;
    private String namespace = "dao.BoardDao.";

    public int countBoard(){
        return sqlSession.selectOne(namespace+"count");
    }
    public BoardDto selectByBn(int id) {
        return sqlSession.selectOne(namespace + "selectByBn", id);
    }
    public int deleteAll(){
        return sqlSession.delete(namespace+"deleteAll");
    }
    public int insert(BoardDto dto){
        return sqlSession.insert(namespace+"insert", dto);
    }
    public int update(BoardDto dto){
        return sqlSession.update(namespace+"update", dto);
    }
    public List<BoardDto> selectList(PageHandler ph){
        return sqlSession.selectList(namespace+"selectList", ph);
    }

}
