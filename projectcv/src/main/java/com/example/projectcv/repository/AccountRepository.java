package com.example.projectcv.repository;

import com.example.projectcv.entity.Role;
import com.example.projectcv.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AccountRepository extends JpaRepository<UserAccount,Long> {
    List<UserAccount> findByRole(Role role);
    UserAccount findByMemberId(Long memberId);
    Optional<UserAccount> findByMemberEmail(String email);
}
