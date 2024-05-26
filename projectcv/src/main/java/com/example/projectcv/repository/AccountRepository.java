package com.example.projectcv.repository;

import com.example.projectcv.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<UserAccount,Long> {

}
