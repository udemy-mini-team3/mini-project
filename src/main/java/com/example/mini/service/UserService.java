package com.example.mini.service;

import com.example.mini.dto.UserDto;

public interface UserService {
    UserDto getUser(String email);
    int insertUser(UserDto dto);


    void update(String email, UserDto userDto);
    int getNicknameCount(String nickname);

    void delete(String email);

    String getPwdBySeq(int seq);

    void updatePw(int seq, String newPwd);

    boolean checkUserEmail(String email);
}
