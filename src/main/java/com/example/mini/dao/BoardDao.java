package com.example.mini.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface BoardDao {
    public Map<String, String> getBoard(int seq);

    // getBoard
	// getBoardList
	// updateBoard
	// deleteBoard
	// insertBoard

}
