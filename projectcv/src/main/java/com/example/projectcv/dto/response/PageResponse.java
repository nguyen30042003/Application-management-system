package com.example.projectcv.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PageResponse<T> extends ApiResponse<T>{
    Meta meta;
}
