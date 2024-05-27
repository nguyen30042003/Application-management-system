package com.example.projectcv.repository;

import com.example.projectcv.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<UserAccount,Long> {
        Optional<UserAccount> findByMemberEmail(String email);
}
