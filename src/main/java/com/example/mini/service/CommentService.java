package com.example.mini.service;

import java.util.HashMap;
import java.util.List;

public interface CommentService {
    List<HashMap<String,String>> getCommentList(int seq);
}
