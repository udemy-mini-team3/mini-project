package com.example.mini.service;

import com.example.mini.dao.BoardDao;
import com.example.mini.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDao dao;

    @Override
    public int getBoardCount() {
        return dao.getBoardCount();
    }

    @Override
    //public List<BoardDto> getBoardList(int limit) {
    public List<Map<String, Object>> getBoardList(int limit) {

        return dao.getBoardList(limit);
    }

    @Override
    public List<Map<String, Object>> getReversedBoardList(int limit) {
        return dao.getReversedBoardList(limit);
    }
}
