package com.example.mini.controller;

import com.example.mini.service.BoardService;
import com.example.mini.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    @Autowired
    @Qualifier("boardService")
    BoardService service;

    @Autowired
    @Qualifier("commentService")
    CommentService commentService;
    @GetMapping("/")
  public String main() {
      return "sample";
  }

    @GetMapping("/board/detail")
    public ModelAndView board(@RequestParam(value="seq", required=true) int seq) {
        ModelAndView mv= new ModelAndView();
        String loginid = "bb@gmail.com";
        Map<String, String> board = service.getBoard(seq);
        List<HashMap<String, String>> commentList = commentService.getCommentList(seq);

        mv.addObject("board", board);
        mv.addObject("commentList", commentList);
        mv.addObject("loginid", loginid);
        mv.setViewName("board/detail");
        return mv;
    }

    @GetMapping("/board/delete")
    public String delete(@RequestParam(value="seq", required=true) int seq) {
        service.deleteBoard(seq);
        return "redirect:/";
    }


}
