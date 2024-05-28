package com.example.projectcv.exception;

public enum ErrorCode {
    USER_EXISTED(1001, "User existed")
    ;
    ErrorCode(int code, String message)
    {
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
