package com.example.mini.service;

import com.example.mini.dao.UserDao;
import com.example.mini.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

    @Autowired
    UserDao dao;

    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "dudghks5722@gmail.com";

    public SendEmailService(UserDao dao, JavaMailSender mailSender) {
        this.dao = dao;
        this.mailSender = mailSender;
    }

    public MailDto createMailAndChangePassword(String email){
        String str = getTempPassword();
        MailDto dto = new MailDto();
        dto.setAddress(email);
        dto.setTitle(" [배용남] 임시비밀번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요. [배용남] 임시비밀번호 안내 관련 이메일 입니다. 임시 비밀번호는 "
                + str + " 입니다.");
        updatePassword(str,email);

        return dto;
    }

    public void updatePassword(String pw,String email){

        int seq = dao.getUser(email).getSeq();
        dao.updatePw(seq,pw);
    }

    public String getTempPassword(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }

    public void mailSend(MailDto mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress());
        message.setFrom(SendEmailService.FROM_ADDRESS);
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());

        mailSender.send(message);
    }
}
