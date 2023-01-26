package com.example.mini.service;

import com.example.mini.dao.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDao dao;

    @Override
    public Map<String, Object> getBoard(int seq) {
        return dao.getBoard(seq);
    }

    @Override
    public void deleteBoard(int seq) {
        dao.deleteBoard(seq);
    }

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
    public List<Map<String, Object>> getRecentBoards() {
        return dao.getRecentBoards();
    }

    @Override
    public List<Map<String, Object>> getPastBoards() {
        return dao.getPastBoards();
    }

    @Override
    public List<Map<String, Object>> getFamousBoards() {
        return dao.getFamousBoards();
    }
}
