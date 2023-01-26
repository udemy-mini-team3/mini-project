package com.example.mini.dao;

import com.example.mini.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BoardDao {
	
	// getBoard
	int getBoardCount();
	//List<BoardDto> getBoardList(int limit);
	List<Map<String, Object>> getBoardList(int limit);
	List<Map<String, Object>> getReversedBoardList(int limit);
	// updateBoard
	// deleteBoard
	// insertBoard

}
