package com.example.projectcv.entity.composite_key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisingFormKey {
    @Column(name = "recruitment_id")
    long recruitmentId;

    @Column(name ="recruitment_time")
    java.util.Date recruitmentTime = new Date();

}
