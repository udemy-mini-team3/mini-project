package com.example.mini.service;

import com.example.mini.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("commentservice")
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao dao;

    @Override
    public List<HashMap<String, String>> getCommentList(int seq) {
        return dao.getCommentList(seq);
    }
}
