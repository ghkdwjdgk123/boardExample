package com.example.boardproject.board.entity;

import com.example.boardproject.board.domain.BoardDto;

import java.util.List;

public class PageHandler {
    private int navSize = 10;
    private int totalCnt;
    private Integer page;
    private Integer pageSize;
    private int totalPage;
    private int beginPage;
    private int endPage;
    private boolean prevPage;
    private boolean nextPage;
    private int offset;
    private List<BoardDto> boardList;  // 게시글 목록

    // 기본 생성자
    public PageHandler() {}

    // 생성자
    public PageHandler(Integer totalCnt, Integer page, Integer pageSize) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;
        this.totalPage = (int) Math.ceil(totalCnt / (double) pageSize);
        this.beginPage = ((page - 1) / navSize) * navSize + 1;
        this.endPage = Math.min(beginPage + (navSize - 1), totalPage);
        this.prevPage = beginPage != 1;
        this.nextPage = endPage != totalPage;
        this.offset = (this.page - 1) * this.pageSize;
    }

    // 게시글 목록 설정
    public void setBoardList(List<BoardDto> boardList) {
        this.boardList = boardList;
    }

    // 게시글 목록 가져오기
    public List<BoardDto> getBoardList() {
        return boardList;
    }

    public int getNavSize() {
        return navSize;
    }

    public void setNavSize(int navSize) {
        this.navSize = navSize;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isPrevPage() {
        return prevPage;
    }

    public void setPrevPage(boolean prevPage) {
        this.prevPage = prevPage;
    }

    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
    // 그 외 getter/setter들...
}
