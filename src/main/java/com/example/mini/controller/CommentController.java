package com.example.mini.controller;

import com.example.mini.dto.CommentDto;
import com.example.mini.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    @Qualifier("commentService")
    CommentService commentService;

    @ResponseBody
    @PostMapping(value="/comment/insert", produces={"application/json;charset=utf-8"})
    public List<Map<String, Object>> getCommentList(CommentDto dto) {
        System.out.println(dto);
        commentService.insertComment(dto);
        List<Map<String, Object>> commentList = commentService.getCommentList(dto.getBoardSeq());
        return commentList;
    }
    // update
    @GetMapping("/comment/update/{seq}")
    public ModelAndView updateComment(@PathVariable("seq") int seq) {
        ModelAndView mv = new ModelAndView();
        CommentDto dto = commentService.getComment(seq);
        mv.addObject("dto", dto);
        mv.setViewName("board/commentform");
        return mv;

    }
    @PostMapping("/comment/update")
    public String updateComment(CommentDto dto) {
        commentService.updateComment(dto);
        return "redirect:/board/detail?seq="+dto.getBoardSeq();
    }

    @GetMapping("/comment/delete/{seq}")
    public String deleteComment(@PathVariable("seq") int seq)  {
        int boardSeq = commentService.getComment(seq).getBoardSeq();
        commentService.deleteComment(seq);
        return "redirect:/board/detail?seq="+boardSeq;
    }

}
