package com.example.mini.controller;

import com.example.mini.dto.CommentDto;
import com.example.mini.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    @Qualifier("commentService")
    CommentService commentService;

    /*
    @PostMapping("/comment/insert")
    public void insertComment(CommentDto dto) {
        dto.setWriter(2);
        commentService.insertComment(dto);
    }
*/
    /*
    @ResponseBody
    @PostMapping(value="/comment/list", produces={"application/json;charset=utf-8"})
    public List<Map<String, String>> getCommentList(@RequestParam(value="seq", required=true) int seq) {
        List<Map<String, String>> commentList = commentService.getCommentList(seq);
        commentService.insertComment(dto);
        return commentList;
    }
     */

    @ResponseBody
    @PostMapping(value="/comment/insert", produces={"application/json;charset=utf-8"})
    public List<Map<String, Object>> getCommentList(CommentDto dto) {
        System.out.println(dto);
        commentService.insertComment(dto);
        List<Map<String, Object>> commentList = commentService.getCommentList(dto.getBoardSeq());
        return commentList;
    }



    // update


    // delete
}
