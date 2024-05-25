package com.example.projectcv.entity.composite_key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

import java.sql.Timestamp;

@Embeddable
public class AdvertisingFormKey {
    @Column(name = "recruitment_id")
    long recruitmentId;

    @Column(name ="recruitment_time")
    Timestamp recruitmentTime;

}
