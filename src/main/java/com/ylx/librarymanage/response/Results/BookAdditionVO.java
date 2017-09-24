package com.ylx.librarymanage.response.Results;

import com.ylx.librarymanage.common.Const;

public class BookAdditionVO {

    private String type = Const.BOOK_TYPE;

    private String ISBN;

    private String editor;

    private Integer pages;

    private Long letters;

    private Double price;

    public BookAdditionVO(String ISBN, String editor, Integer pages, Long letters, Double price) {
        this.ISBN = ISBN;
        this.editor = editor;
        this.pages = pages;
        this.letters = letters;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getEditor() {
        return editor;
    }

    public Integer getPages() {
        return pages;
    }

    public Long getLetters() {
        return letters;
    }

    public Double getPrice() {
        return price;
    }
}
