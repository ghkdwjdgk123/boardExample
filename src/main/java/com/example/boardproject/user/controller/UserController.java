package com.example.boardproject.user.controller;

import com.example.boardproject.user.domain.UserDto;
import com.example.boardproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        model.addAttribute("path", referer != null ? referer : "/");
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto,HttpSession session) {
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("content-type", "application/json;charset=UTF-8");
        if (userService.UserCheck(userDto)) {
            session.setAttribute("userId", userDto.getId());

            return new ResponseEntity<>("로그인 성공", resHeaders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("로그인 실패", resHeaders, HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(UserDto userDto, HttpSession session) {
        int status=userService.registerUser(userDto);
        String tbody = "회원가입 성공";
        session.setAttribute("user", userDto);
        if (status==0)
            tbody = "회원가입 실패했습니다 다시시도하세요.";
        return ResponseEntity.ok(tbody);
    }
}
