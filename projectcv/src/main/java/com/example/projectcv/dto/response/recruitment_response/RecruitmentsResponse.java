package com.example.projectcv.dto.response.recruitment_response;

import com.example.projectcv.dto.response.nominee_response.NomineeResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecruitmentsResponse {
    private  long id;
    private int time;
    private EnterpriseResponse enterprise = new EnterpriseResponse();
    private List<NomineeResponse> nominees = new ArrayList<>();
    private PaymentRespone paymentRespone = new PaymentRespone();
}

