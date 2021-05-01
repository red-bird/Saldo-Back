package com.redbird.SaldoBack.repositories;

import com.redbird.SaldoBack.models.Transaction;
import com.redbird.SaldoBack.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByUser(User user);
}
