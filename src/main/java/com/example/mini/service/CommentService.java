package com.example.mini.service;

import com.example.mini.dto.CommentDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Map<String,Object>> getCommentList(int seq);
    void insertComment(CommentDto dto);
}
