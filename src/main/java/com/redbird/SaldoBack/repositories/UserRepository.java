package com.redbird.SaldoBack.repositories;

import com.redbird.SaldoBack.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
