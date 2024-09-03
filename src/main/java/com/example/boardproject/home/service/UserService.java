package com.example.boardproject.home.service;

import com.example.boardproject.home.dao.UserDao;
import com.example.boardproject.home.domain.UserDto;
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
        return dto.getPassword().equals(user.getPassword());
    }
}
