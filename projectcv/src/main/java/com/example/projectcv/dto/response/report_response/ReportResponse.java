package com.example.projectcv.dto.response.report_response;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ReportResponse {
    long id;
    Date date;
    List<ReportDetailResponse> reportDetailResponeList = new ArrayList<>();

}
