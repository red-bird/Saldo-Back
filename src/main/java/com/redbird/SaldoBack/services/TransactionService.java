package com.redbird.SaldoBack.services;

import com.redbird.SaldoBack.models.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction getById(Long id);
    public List<Transaction> getAll();
    public Transaction save(Transaction transaction);
    public void delete(Long id);
//    public Transaction update();
}
