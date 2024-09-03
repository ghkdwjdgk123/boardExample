package com.example.boardproject.board.domain;

import java.sql.Timestamp;

public class BoardDto {
    private Long bn;
    private String title;
    private String content;
    private String writer;
    private Timestamp created;
    private String cr_id = "admin";
    private Timestamp updated;
    private String ur_id = "admin";
    public BoardDto() {}

    public Long getBn() {
        return bn;
    }

    public void setBn(Long bn) {
        this.bn = bn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getCr_id() {
        return cr_id;
    }

    public void setCr_id(String cr_id) {
        this.cr_id = cr_id;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public String getUr_id() {
        return ur_id;
    }

    public void setUr_id(String ur_id) {
        this.ur_id = ur_id;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bn=" + bn +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", created=" + created +
                ", cr_id='" + cr_id + '\'' +
                ", updated=" + updated +
                ", ur_id='" + ur_id + '\'' +
                '}';
    }
}
