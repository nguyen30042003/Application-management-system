package com.example.projectcv.entity;

import com.example.projectcv.entity.composite_key.AdvertisingFormKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "advertising_form")
public class AdvertisingForm {

    @EmbeddedId
    AdvertisingFormKey id = new AdvertisingFormKey();

    @Column(name = "type")
    private AdvertisingType type; // enum

    @MapsId("recruitmentId")
    @OneToOne(optional = false)
    @JoinColumns(
            {
                    @JoinColumn(
                            referencedColumnName = "id",nullable = false
                    )
            }
    )

    private RecruitmentInformation recruitmentInformation;


}
