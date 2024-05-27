package com.example.projectcv.repository;

import com.example.projectcv.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<UserAccount,Long> {
    List<UserAccount> findByRole(String role);
    UserAccount findByMemberId(Long memberId);

}
