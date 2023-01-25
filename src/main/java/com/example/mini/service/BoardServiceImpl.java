package com.example.mini.service;

import com.example.mini.dao.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("boardservice")
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDao dao;

    @Override
    public Map<String, String> getBoard(int seq) {
        return dao.getBoard(seq);
    }

    @Override
    public void deleteBoard(int seq) {
        dao.deleteBoard(seq);
    }


}
