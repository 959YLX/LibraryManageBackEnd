package com.ylx.librarymanage.response;

public enum ErrorCode {
    SYSTEM_ERROR(1, "系统错误"),
    ARGUMENT_ERROR(2, "参数错误")
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
