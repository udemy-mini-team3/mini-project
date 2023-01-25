package com.example.mini.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface BoardDao {

    // getBoard
    Map<String, String> getBoard(int seq);

    // getBoardList
    // updateBoard
    // deleteBoard
    void deleteBoard(int seq);

    // insertBoard

}
