package com.example.projectcv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "candidate")
public class Candidate extends Member{

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private Set<ApplicationForm> applicationForm;


}
