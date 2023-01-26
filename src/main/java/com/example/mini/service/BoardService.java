package com.example.mini.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

    Map<String,Object> getBoard(int seq);
    void deleteBoard(int seq);
    int getBoardCount();
    //List<BoardDto> getBoardList(int limit);
    List<Map<String, Object>> getBoardList(int limit);
    List<Map<String, Object>> getReversedBoardList(int limit);
}
