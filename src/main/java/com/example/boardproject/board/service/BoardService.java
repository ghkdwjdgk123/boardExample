package com.example.boardproject.board.service;

import com.example.boardproject.board.dao.BoardDao;
import com.example.boardproject.board.domain.BoardDto;
import com.example.boardproject.board.entity.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardDao boardDao;

    public BoardDto getBoardByBn(int id) {
        return boardDao.selectByBn(id);

    }
    public PageHandler getBoards(int pageNo) {
        PageHandler ph = new PageHandler(boardDao.countBoard(), pageNo, 10);
        List<BoardDto>dtolist = boardDao.selectList(ph);
        ph.setBoardList(dtolist);
        ph.setTotalCnt(boardDao.countBoard());
        return ph;
    }
    public int insertBoard(BoardDto board) {
        return boardDao.insert(board);
    }
    public int updateBoard(BoardDto board) {
        return boardDao.update(board);
    }

}
