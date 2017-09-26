package com.ylx.librarymanage.response.Results;

import com.ylx.librarymanage.common.Const;

public class BookAdditionVO {

    private String type = Const.BOOK_TYPE;

    private String isbn;

    private String editor;

    private Integer pages;

    private Long letters;

    private Double price;

    public BookAdditionVO(String isbn, String editor, Integer pages, Long letters, Double price) {
        this.isbn = isbn;
        this.editor = editor;
        this.pages = pages;
        this.letters = letters;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getIsbn() {
        return isbn;
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
