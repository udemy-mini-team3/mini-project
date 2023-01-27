package com.example.mini.controller;

import com.example.mini.dto.MailDto;
import com.example.mini.dto.UserPwdDto;
import com.example.mini.dto.UserDto;
import com.example.mini.service.SendEmailService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    UserService service;

    @Autowired
    SendEmailService sendEmailService;

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
            view = "redirect:/register";
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

        if (checkDuplicateNickname(userDto, session)){
            bindingResult.rejectValue("nickname", "duplicate.nickname");
            return "user/myPage";
        }

        service.update(userDto.getEmail(), userDto);
        //회원 정보 변경에 따른 세션 변경
        session.setAttribute(SessionConst.LOGIN_USER, service.getUser(userDto.getEmail()));
        return "redirect:/myPage";
    }

    //닉네임 중복 검사 함수
    private boolean checkDuplicateNickname(UserDto userDto, HttpSession httpSession) {
        int nickCount = service.getNicknameCount(userDto.getNickname());

        UserDto sessionUserDto = (UserDto) httpSession.getAttribute(SessionConst.LOGIN_USER);
        if(userDto.getNickname().equals(sessionUserDto.getNickname()))
            return false;

        if(nickCount > 0){
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

    //비밀번호 변경 화면
    @GetMapping("/pwChange")
    public String changePwForm(Model model){

        Object success = model.getAttribute("success");
        model.addAttribute("userPwdDto",new UserPwdDto());

        return "user/pwChange";
    }

    //비밀번호 변경
    @PostMapping ("/pwChange")
    public String changePwd( @ModelAttribute("userPwdDto") @Valid UserPwdDto userPwdDto, BindingResult bindingResult,
                             HttpSession session, RedirectAttributes redirectAttributes){


        if(bindingResult.hasErrors()){
            return "user/pwChange";
        }

        UserDto userDto = (UserDto) session.getAttribute(SessionConst.LOGIN_USER);
        if(checkPw(userDto, userPwdDto, bindingResult))
            return "user/pwChange";
        //성공 로직
        service.updatePw(userDto.getSeq(), userPwdDto.getNewPwd());
        redirectAttributes.addFlashAttribute("result", "success");
        //비밀번호 변경에 따른 세션 변경
        session.setAttribute(SessionConst.LOGIN_USER, service.getUser(userDto.getEmail()));

        return "redirect:/myPage";
    }

    //패스워드 검사 함수
    private boolean checkPw(UserDto userDto, UserPwdDto userPwdDto, BindingResult bindingResult) {

        boolean checkResult = false;
        //기존 비밀번호가 일치하지 않는다면
        if(!service.getPwdBySeq(userDto.getSeq()).equals(userPwdDto.getOldPwd())){
            bindingResult.rejectValue("oldPwd", "notSame.oldPwd");
            checkResult = true;
        }

        //새 비밀번호와 새 비밀번호 확인이 일치하지 않는다면
        if(!userPwdDto.getNewPwd().equals(userPwdDto.getNewPwdConf())){
            bindingResult.rejectValue("newPwdConf", "notSame.newPwd");
            checkResult = true;
        }
        return checkResult;
    }

    //이메일 존재여부 확인
    @GetMapping("/findPw")
    @ResponseBody
    public Map<String, Boolean> findPw(String email){
        Map<String,Boolean> json = new HashMap<>();
        boolean pwFindCheck = service.checkUserEmail(email);

        json.put("check", pwFindCheck);

        return json;
    }

    //등록된 이메일로 임시비밀번호 발송, 발송된 임시비밀번호로 사용자의 pw를 변경
    @PostMapping("/findPw/sendEmail")
    public @ResponseBody void sendEmail(String email){
        MailDto mailDto = sendEmailService.createMailAndChangePassword(email);
        sendEmailService.mailSend(mailDto);
    }

}
