package com.example.boardproject.user.service;

import com.example.boardproject.user.dao.UserDao;
import com.example.boardproject.user.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public int registerUser(UserDto dto){
        return userDao.insert(dto);
    }
    public boolean UserCheck(UserDto dto){
        UserDto user=userDao.checkById(dto.getId());
        return (dto.getPassword()).equals(user.getPassword());
    }
}
