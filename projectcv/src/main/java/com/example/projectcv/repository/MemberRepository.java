package com.example.projectcv.repository;


import com.example.projectcv.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository  extends JpaRepository<Member,Long> {


    List<Member> findByName(String name);
    List<Member> findByEmail(String email);
    List<Member> findByContact(String  contact);
    List<Member> findByAddress(String address);
    Member findFirstByName(String name);
    boolean existsByName(String name);
}
