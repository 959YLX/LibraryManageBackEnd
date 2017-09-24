package com.ylx.librarymanage.dao;

public class SearchObject {

    private String keyword;
    private Boolean trash;

    public SearchObject(String keyword, Boolean trash) {
        this.keyword = keyword;
        this.trash = trash;
    }

    public String getKeyword() {
        return keyword;
    }

    public Boolean getTrash() {
        return trash;
    }
}
