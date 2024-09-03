package com.example.boardproject.home.dao;

import com.example.boardproject.home.domain.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testcheckById() {
        userDao.deleteAll();
        UserDto dto = new UserDto();
        dto.setName("정하");
        dto.setId("jeong");
        dto.setPassword("123456");
        dto.setBirthDay(new Date(97, 6, 21)); // 1997년 7월 21일
        userDao.insert(dto);
        UserDto dto1 = userDao.checkById("jeong");
        assertNotNull(dto1);
        dto.getId().equals(dto1.getId());
        dto.getPassword().equals(dto1.getPassword());
        dto.getBirthDay().equals(dto1.getBirthDay());
    }
}
