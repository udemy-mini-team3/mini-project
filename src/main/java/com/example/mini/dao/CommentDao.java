package com.example.mini.dao;

import com.example.mini.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper 
@Repository
public interface CommentDao {

    List<Map<String,Object>> getCommentList(int seq);
    void insertComment(CommentDto dto);

}
