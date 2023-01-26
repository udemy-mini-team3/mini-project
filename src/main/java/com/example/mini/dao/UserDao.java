package com.example.mini.dao;

import com.example.mini.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    UserDto getUser(String email);
    int insertUser(UserDto dto);


    void update(@Param("email") String email, @Param("userDto") UserDto dto);
    int getEmailCount(String email);
    void delete(String email);

    String getPwdBySeq(int seq);

    void updatePw(@Param("seq") int seq, @Param("newPwd") String newPwd);
}
