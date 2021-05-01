package com.redbird.SaldoBack.services;

import com.redbird.SaldoBack.models.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction getById(Long id);
    public List<Transaction> getAll();
    public Transaction save(Transaction transaction, String username);
    public void delete(Long id);
    public void deleteByUser(Long id, String username);
    public Transaction getByIdByUser(Long id, String username);
    public List<Transaction> getAllByUser(String username);
//    public Transaction update();
}
