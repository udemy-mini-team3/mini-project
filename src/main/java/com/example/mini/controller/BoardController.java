package com.example.mini.controller;

import com.example.mini.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class BoardController {

    @Autowired
    @Qualifier("boardservice")
    BoardService service;

  @GetMapping("/")
  public String main() {
      return "sample";
  }
    @GetMapping("/board/detail")
    public ModelAndView board(@RequestParam(value="seq", required=true) int seq) {
        ModelAndView mv= new ModelAndView();

        Map<String, String> board = service.getBoard(seq);
        mv.addObject("board", board);
        mv.setViewName("board/detail");
        return mv;
    }

}
