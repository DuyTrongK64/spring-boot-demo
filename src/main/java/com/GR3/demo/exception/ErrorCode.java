package com.GR3.demo.exception;

import org.springframework.http.HttpStatus;

import java.net.http.HttpRequest;

public enum ErrorCode {
    USER_EXISTED(HttpStatus.CONFLICT.value(), "User extsted!"),
    UNCATEGORIZED_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Uncategoried error!"),
    INVALID_KEY(HttpStatus.BAD_REQUEST.value(), "Invalid message key"),
    PASSWORD_INVALID(HttpStatus.UNAUTHORIZED.value(), "Password must have least 8 charactor"),
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
