package com.example.projectcv.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    USER_EXISTED(1001, "User existed", 409),
    SignIn_Fail(1002, "Email or Password is invalid", 400),
    UN_AUTHORIZED(1001,"You are not authorized",401), ;

    private final int code;
    private final String message;
    private final int httpStatusCode;

}
