package com.example.mini.dao;

import com.example.mini.dto.BoardDto;
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
	List<Map<String, Object>> getRecentBoards();
	List<Map<String, Object>> getPastBoards();
	List<Map<String, Object>> getFamousBoards();
    Map<String, Object> getBoard(int seq);

    // getBoardList

    // deleteBoard
    void deleteBoard(int seq);

	void updateBoard(BoardDto dto);
	void insertBoard(BoardDto dto);

}
