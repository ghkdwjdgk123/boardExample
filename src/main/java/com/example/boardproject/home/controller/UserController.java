package com.example.boardproject.home.controller;

import com.example.boardproject.home.domain.UserDto;
import com.example.boardproject.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
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
    public String login(String path, HttpServletRequest request, HttpSession session, UserDto userDto, Model model) {
        if (userService.UserCheck(userDto)) {
            session.setAttribute("user", userDto);
            return "redirect:" + (path != null ? path : "/");
        } else {
            model.addAttribute("path", path);
            model.addAttribute("loginError", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(UserDto userDto, HttpSession session) {
        userService.registerUser(userDto);
        session.setAttribute("user", userDto);
        return "home";
    }
}
