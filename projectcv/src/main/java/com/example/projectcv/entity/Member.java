package com.example.projectcv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "member")
@Inheritance(strategy = InheritanceType.JOINED)
public class Member {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "contact")
    private String contact;

    @Column(name = "is_validated")
    private boolean isValidated ;

    @Column(name = "created_at")
    private Date createdAt;

    @OneToOne(optional = false , mappedBy = "member",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private UserAccount userAccount;


}
