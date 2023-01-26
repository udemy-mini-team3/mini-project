package com.example.mini.service;

import com.example.mini.dto.BoardDto;

import java.util.List;
import java.util.Map;

public interface BoardService {

    int getBoardCount();
    //List<BoardDto> getBoardList(int limit);
    List<Map<String, Object>> getBoardList(int limit);
    List<Map<String, Object>> getReversedBoardList(int limit);
}
