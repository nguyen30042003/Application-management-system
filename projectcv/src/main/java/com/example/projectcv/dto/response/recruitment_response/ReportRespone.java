package com.example.projectcv.dto.response.recruitment_response;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ReportRespone {
    long id;
    Date date;
    List<ReportDetailRespone> reportDetailResponeList = new ArrayList<>();

}
