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
}
