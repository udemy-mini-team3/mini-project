package com.example.mini.service;

import com.example.mini.dao.UserDao;
import com.example.mini.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao dao;

    @Override
    public UserDto getUser(String email) {
        return dao.getUser(email);
    }

    @Override
    public int insertUser(UserDto dto) {
        return dao.insertUser(dto);
    }


    @Override
    public void update(String email, UserDto userDto) {
        dao.update(email, userDto);
    }

    @Override
    public int getNicknameCount(String nickname) {
        return dao.getNicknameCount(nickname);
    }


    @Override
    public void delete(String email) {
        dao.delete(email);
    }

    @Override
    public String getPwdBySeq(int seq) {
        return dao.getPwdBySeq(seq);
    }

    @Override
    public void updatePw(int seq, String newPwd) {
        dao.updatePw(seq, newPwd);
    }

    @Override
    public boolean checkUserEmail(String email) {
        if(dao.checkUserEmail(email) == 0) return false;
        return true;
    }
}
