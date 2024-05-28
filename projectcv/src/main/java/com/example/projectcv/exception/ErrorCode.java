package com.example.projectcv.exception;

public enum ErrorCode {
    USER_EXISTED(1001, "User existed", 409),
    SignIn_Fail(1002, "Email or Password is invalid", 400),
    UN_AUTHORIZED(1001,"You are not authorized",401),
    ;
    ErrorCode(int code, String message, int httpStatusCode)
    {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
    private int code;
    private String message;
    private int httpStatusCode;

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
