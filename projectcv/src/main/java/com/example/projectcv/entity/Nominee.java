package com.example.projectcv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "nominee")
public class Nominee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "nominee", cascade = CascadeType.ALL)
    private Set<RecruitmentDetail> recruitmentDetails;

}
