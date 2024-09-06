package com.example.boardproject.user.controller;

import com.example.boardproject.user.domain.UserDto;
import com.example.boardproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
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
    public ResponseEntity<String> login(String path, HttpServletRequest request, HttpSession session, UserDto userDto, Model model) {
        if (userService.UserCheck(userDto)) {
            session.setAttribute("userId", userDto.getId());
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.ok("아이디나 비밀번호가 틀림니다.");
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
