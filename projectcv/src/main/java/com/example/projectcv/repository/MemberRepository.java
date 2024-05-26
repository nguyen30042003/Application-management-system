package com.example.projectcv.repository;


import com.example.projectcv.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member,Long> {
}
