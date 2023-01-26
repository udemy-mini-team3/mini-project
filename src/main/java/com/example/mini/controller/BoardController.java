package com.example.mini.controller;

import com.example.mini.dto.UserDto;
import com.example.mini.service.BoardService;
import com.example.mini.service.CommentService;
import com.example.mini.util.SessionConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    @GetMapping("/board/detail")
    public ModelAndView board(@RequestParam(value="seq", required=true) int seq, HttpSession session) {
        ModelAndView mv= new ModelAndView();
        boolean isWriter = false;
        UserDto userDto = (UserDto) session.getAttribute(SessionConst.LOGIN_USER);
        Map<String, Object> board = service.getBoard(seq);
        List<Map<String, Object>> commentList = commentService.getCommentList(seq);

        if (userDto == null) {
            isWriter = false;
        } else if (board.get("userSeq").equals(userDto.getSeq())) {
            isWriter = true;
        }

        mv.addObject("board", board);
        mv.addObject("commentList", commentList);
        mv.addObject("userDto", userDto);
        mv.addObject("isWriter", isWriter);
        mv.setViewName("board/detail");
        return mv;
    }

    @GetMapping("/board/delete")
    public String delete(@RequestParam(value="seq", required=true) int seq) {
        service.deleteBoard(seq);
        return "redirect:/";
    }


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
        List<Map<String, Object>> boardList = new ArrayList<>();
        if (page == 1) {
            boardList = service.getRecentBoards();
        } else if (page == 2) {
            boardList = service.getPastBoards();
        } else if (page == 3) {
            boardList = service.getFamousBoards();
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
