package com.example.mini.service;

import com.example.mini.dto.UserDto;

public interface UserService {
    UserDto getUser(String email);
    int insertUser(UserDto dto);


    void update(String email, UserDto userDto);
    int getEmailCount(String email);

    void delete(String email);


}
