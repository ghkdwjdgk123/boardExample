package com.example.boardproject.board.controller;

import com.example.boardproject.board.domain.BoardDto;
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
    public List<BoardDto> board(Integer pageNo) {
        pageNo = pageNo == null ? 1 : pageNo;
        return boardService.getBoards(pageNo);
    }
    @GetMapping("/read")
    public BoardDto read(Integer boardNo) {
        return boardService.getBoardByBn(boardNo);
    }
    @PostMapping("/register")
    public List<BoardDto> register(BoardDto boardDto) {
        boardService.insertBoard(boardDto);
        return boardService.getBoards(1);
    }
    @PatchMapping("/update")
    public ResponseEntity<String> update(BoardDto boardDto) {
        boardService.updateBoard(boardDto);
        return ResponseEntity.ok("업데이트 성공");
    }
}
