package com.example.mini.dao;

import com.example.mini.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    UserDto getUser(String email);
    int insertUser(UserDto dto);
}
