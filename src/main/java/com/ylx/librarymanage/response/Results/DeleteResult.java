package com.ylx.librarymanage.response.Results;

public class DeleteResult {

    private Integer deleteNumber;
    private Integer trashNumber;

    public DeleteResult(Integer deleteNumber, Integer trashNumber) {
        this.deleteNumber = deleteNumber;
        this.trashNumber = trashNumber;
    }

    public Integer getDeleteNumber() {
        return deleteNumber;
    }

    public Integer getTrashNumber() {
        return trashNumber;
    }
}
