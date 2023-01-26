package com.example.mini.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BoardDao {
	
	int getBoardCount();
	//List<BoardDto> getBoardList(int limit);
	List<Map<String, Object>> getBoardList(int limit);
	List<Map<String, Object>> getReversedBoardList(int limit);
    Map<String, Object> getBoard(int seq);

    // getBoardList
    // updateBoard
    // deleteBoard
    void deleteBoard(int seq);

    // insertBoard

}
