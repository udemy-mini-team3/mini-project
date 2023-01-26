package com.example.mini.controller;

import com.example.mini.dto.UserDto;
import com.example.mini.service.UserService;
import com.example.mini.util.SessionConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    UserService service;

    // 로그인 폼
    @GetMapping("/login")
    public String login() {
        return "user/loginForm";
    }

    // 로그인
    @PostMapping("/login")
    public String login(String email, String pw, HttpSession session) {
        UserDto dto = service.getUser(email);
        String view = "";
        if (dto == null) {
            view = "/register";
        } else {
            if (pw.equals(dto.getPw())) {
                session.setAttribute(SessionConst.LOGIN_USER, email);
                view = "redirect:/";
            } else {
                view = "user/loginForm";
            }
        }
        return view;
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute(SessionConst.LOGIN_USER) != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    // 회원가입 폼
    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    // 회원가입
    @PostMapping("/register")
    public String register(UserDto dto) {
        UserDto userDto = service.getUser(dto.getEmail());
        if (userDto == null) {
            service.insertUser(dto);
        }
        return "redirect:/";
    }
}
