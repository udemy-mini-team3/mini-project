package com.example.mini.controller;

import com.example.mini.dto.UserDto;
import com.example.mini.service.UserService;
import com.example.mini.util.SessionConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
                session.setAttribute(SessionConst.LOGIN_USER, dto);
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

    //마이페이지
    @GetMapping("/myPage")
    public String myPage(HttpSession session, Model model) {
        UserDto userDto = (UserDto) session.getAttribute(SessionConst.LOGIN_USER);

        model.addAttribute("userDto", userDto);
        return "user/myPage";
    }

    //마이페이지 수정
    @PostMapping("/myPage")
    public String myPageEdit(@ModelAttribute("userDto") @Valid UserDto userDto,
                             BindingResult bindingResult, HttpSession session) {

        if(bindingResult.hasErrors()){
            return "user/myPage";
        }


        if (checkDuplicateEmail(userDto, session)){
            bindingResult.rejectValue("email", "duplicate.email");
            return "user/myPage";
        }

        service.update(userDto.getEmail(), userDto);
        //회원 정보 변경에 따른 세션 변경
        session.setAttribute(SessionConst.LOGIN_USER, service.getUser(userDto.getEmail()));




        return "redirect:/myPage";
    }

    //이메일 중복 검사 함수
    private boolean checkDuplicateEmail(UserDto userDto, HttpSession httpSession) {
        int emailCount = service.getEmailCount(userDto.getEmail());

        UserDto sessionUserDto = (UserDto) httpSession.getAttribute(SessionConst.LOGIN_USER);

        if(userDto.getEmail().equals(sessionUserDto.getEmail()))
            return false;

        if(emailCount > 0){
            return true;
        }
        return false;
    }

    //마이페이지-회원탈퇴
    @GetMapping("/user/delete")
    public String delete(HttpSession httpSession) {
        UserDto userDto = (UserDto)httpSession.getAttribute(SessionConst.LOGIN_USER);
        service.delete(userDto.getEmail());
        httpSession.invalidate();
        return "redirect:/";
    }

}
