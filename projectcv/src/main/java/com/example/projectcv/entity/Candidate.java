package com.example.projectcv.entity;

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
@Table(name = "candidate")
public class Candidate extends Member{

    @OneToOne(mappedBy = "candidate")
    private ApplicationForm applicationForm;

}
