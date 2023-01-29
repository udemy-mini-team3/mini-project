package com.example.mini.service;

import com.example.mini.dto.BoardDto;

import java.util.List;
import java.util.Map;

public interface BoardService {

    Map<String,Object> getBoard(int seq);
    void deleteBoard(int seq);
    int getBoardCount();
    //List<BoardDto> getBoardList(int limit);
    List<Map<String, Object>> getBoardList(int limit);
    List<Map<String, Object>> getRecentBoards();
    List<Map<String, Object>> getPastBoards();
    List<Map<String, Object>> getFamousBoards();

    void insertBoard(BoardDto dto);
    void updateBoard(BoardDto dto);

}
