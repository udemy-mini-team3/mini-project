package com.example.mini.controller;

import com.example.mini.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
        mv.setViewName("board/index");
        return mv;
    }

    @GetMapping("/boardlist")
    public ModelAndView boardList(int page) {
        ModelAndView mv = new ModelAndView();
        int limit = (page - 1) * 5;
        List<Map<String, Object>> boardList = service.getBoardList(limit);
        int boardCount = service.getBoardCount();
        int pageCount = (boardCount / 5) + 1;
        mv.addObject("boardList", boardList);
        mv.addObject("pageCount", pageCount);
        mv.setViewName("board/index");
        return mv;
    }

    @ResponseBody
    @GetMapping(value = "/boardlist/sorted/{page}", produces = {"application/json;charset=utf-8"})
    public List<Map<String, Object>> sortedList(@PathVariable("page") int page) {
        //int limit = (page - 1) * 5 ;
        List<Map<String, Object>> boardList = new ArrayList<>();
        if (page == 1) {
            boardList = service.getReversedBoardList(0);
        } else if (page == 2) {
            boardList = service.getReversedBoardList(0);
        } else if (page == 3) {
            boardList = service.getReversedBoardList(0);
        }
        return boardList;
    }

    @GetMapping("/writeboard")
    public String writeBoard() {
        return "board/sample";
    }

    @GetMapping("/getboard")
    public String getBoard() {
        return "board/sample";
    }

}
