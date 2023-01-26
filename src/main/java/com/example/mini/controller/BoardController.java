package com.example.mini.controller;

import com.example.mini.dto.BoardDto;
import com.example.mini.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    @Autowired
    @Qualifier("boardService")
    BoardService service;

  @GetMapping("/")
  public ModelAndView main() {

      ModelAndView mv = new ModelAndView();
      List<Map<String, Object>> boardList = service.getBoardList(0);
      int boardCount = service.getBoardCount();
      int pageCount = (boardCount / 5) + 1;
      mv.addObject("boardList", boardList);
      mv.addObject("pageCount", pageCount);
      mv.setViewName("index");
      return mv;
  }

  @GetMapping("/boardlist")
  public ModelAndView boardList(int page) {
      ModelAndView mv = new ModelAndView();
      int limit = (page - 1) * 5 ;
      List<Map<String, Object>> boardList = service.getBoardList(limit);
      int boardCount = service.getBoardCount();
      int pageCount = (boardCount / 5) + 1;
      mv.addObject("boardList", boardList);
      mv.addObject("pageCount", pageCount);
      mv.setViewName("index");
      return mv;



  }

  @GetMapping("/writeboard")
  public String writeBoard() {
      return "sample";
  }

    @GetMapping("/getboard")
    public String getBoard() {
        return "sample";
    }
	
}
