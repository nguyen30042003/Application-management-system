package com.example.projectcv.dto.response;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T data;

}
