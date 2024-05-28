package com.example.projectcv.dto.response;

import lombok.Data;

@Data
public class Meta {
    int page;
    int pageSize;
    int totalPages;
    int totalItems;

}
