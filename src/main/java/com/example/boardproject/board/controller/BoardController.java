package com.example.boardproject.board.controller;

import com.example.boardproject.board.domain.BoardDto;
import com.example.boardproject.board.entity.PageHandler;
import com.example.boardproject.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public PageHandler board(Integer pageNo) {
        pageNo = pageNo == null ? 1 : pageNo;
        System.out.println(boardService.getBoards(pageNo));
        return boardService.getBoards(pageNo);
    }
    @GetMapping("/read")
    public BoardDto read(@RequestParam Integer boardNo) {
        return boardService.getBoardByBn(boardNo);
    }
    @PostMapping("/register")
    public PageHandler register(@RequestBody BoardDto boardDto) {
        boardService.insertBoard(boardDto);
        System.out.println(boardDto);
        return boardService.getBoards(1);
    }
    @PatchMapping("/update")
    public ResponseEntity<String> update(@RequestBody BoardDto boardDto) {
        boardService.updateBoard(boardDto);
        return ResponseEntity.ok("업데이트 성공");
    }
}
