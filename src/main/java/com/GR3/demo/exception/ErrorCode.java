package com.GR3.demo.exception;

public enum ErrorCode {
    USER_EXISTED(1001,"User extsted!"),
    UNCATEGORIZED_EXCEPTION(400,"Uncategoried error!")
    ;
    private  int code;
    private String message;

    ErrorCode(int code, String message) {
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
