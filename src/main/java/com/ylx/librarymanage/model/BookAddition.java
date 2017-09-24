package com.ylx.librarymanage.model;

import java.util.Date;

public class BookAddition {
    private Integer uid;

    private Integer id;

    private String isbn;

    private String editor;

    private Integer pageCount;

    private Long letterCount;

    private Double letterPrice;

    private Date updateTime;

    private Date createTime;

    public BookAddition(Integer uid, Integer id, String isbn, String editor, Integer pageCount, Long letterCount, Double letterPrice, Date updateTime, Date createTime) {
        this.uid = uid;
        this.id = id;
        this.isbn = isbn;
        this.editor = editor;
        this.pageCount = pageCount;
        this.letterCount = letterCount;
        this.letterPrice = letterPrice;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public BookAddition() {
    }

    public BookAddition(Integer id, String isbn, String editor, Integer pageCount, Long letterCount, Double letterPrice) {
        this.id = id;
        this.isbn = isbn;
        this.editor = editor;
        this.pageCount = pageCount;
        this.letterCount = letterCount;
        this.letterPrice = letterPrice;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Long getLetterCount() {
        return letterCount;
    }

    public void setLetterCount(Long letterCount) {
        this.letterCount = letterCount;
    }

    public Double getLetterPrice() {
        return letterPrice;
    }

    public void setLetterPrice(Double letterPrice) {
        this.letterPrice = letterPrice;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}