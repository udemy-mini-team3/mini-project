package com.example.mini.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper 
@Repository
public interface CommentDao {

    List<HashMap<String,String>> getCommentList(int seq);

}
