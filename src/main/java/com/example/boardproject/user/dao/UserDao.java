package com.example.boardproject.user.dao;

import com.example.boardproject.user.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    SqlSession sqlSession;
    String namespace = "dao.UserDao.";

    public int deleteAll(){
        return sqlSession.delete(namespace + "deleteAll");
    }
    public UserDto checkById(String id) {
        return sqlSession.selectOne(namespace+"selectById", id);
    }
    public int insert(UserDto user) {
        return sqlSession.insert(namespace+"insert", user);
    }
    public int update(UserDto user) {
        return sqlSession.update(namespace+"update", user);
    }
    public List<UserDto> selectAll() {
        return sqlSession.selectList(namespace+"selectAll");
    }
}
