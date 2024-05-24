package com.example.projectcv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "advertising_form")
public class AdvertisingForm {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "type")
    private String type;
    @OneToOne
    @JoinColumn(name = "recruitID", referencedColumnName = "id")
    private RecruitmentInformation recruitmentInformation;

}
