package com.example.projectcv.dto.response.recruitment_response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RecruitmentsResponse {
    private  long id;
    private int time;
    private EnterpriseResponse enterprise = new EnterpriseResponse();
    private List<NomineeResponse> nominees = new ArrayList<>();
}

