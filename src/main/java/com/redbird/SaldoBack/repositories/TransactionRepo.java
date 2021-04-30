package com.redbird.SaldoBack.repositories;

import com.redbird.SaldoBack.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
