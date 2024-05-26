package com.example.projectcv.repository;

import com.example.projectcv.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NomineeRepository extends JpaRepository<Nominee, Long> {
}
