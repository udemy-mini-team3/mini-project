package com.example.mini.service;

import java.util.Map;

public interface BoardService {

    Map<String,Object> getBoard(int seq);
    void deleteBoard(int seq);
}
