package com.example.projectcv.dto.response;

import java.util.List;

public class ListResponse<T> extends ApiResponse<T>{
    private List<T> items;
    Meta meta;
}
