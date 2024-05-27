package com.example.projectcv.repository;

import com.example.projectcv.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NomineeRepository extends JpaRepository<Nominee, Long> {
    List<Nominee> findByName(String name);

}
