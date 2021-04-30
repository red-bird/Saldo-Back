package com.redbird.SaldoBack.servicesImpl;

import com.redbird.SaldoBack.models.Transaction;
import com.redbird.SaldoBack.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.redbird.SaldoBack.repositories.TransactionRepo;

import java.util.List;

/**
 * Class which process queries about transactions
 */
@Service
@Transactional
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo transactionRepo;

    public TransactionServiceImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }


    /**
     * Get transaction by it's id
     * @param id - unique number of transaction
     * @return Transaction object
     */
    @Override
    public Transaction getById(Long id) {
        Transaction transaction = transactionRepo.findById(id).orElse(null);
        log.info(String.format("get %s"), transaction);
        return transaction;
    }

    /**
     * Get all transactions
     * @return List of transaction objects
     */
    @Override
    public List<Transaction> getAll() {
        List<Transaction> all = transactionRepo.findAll();
        log.info(String.format("get %s", all));
        return all;
    }

    /**
     * Save transaction
     * @param transaction transaction object to save
     * @return transaction object that was saved by DB
     */
    @Override
    public Transaction save(Transaction transaction) {
        Transaction save = transactionRepo.save(transaction);
        log.info(String.format("save %s", transaction));
        return save;
    }

    /**
     * Delete transaction by it's id
     * @param id - id of transaction
     */
    @Override
    public void delete(Long id) {
        transactionRepo.deleteById(id);
        log.info(String.format("delete transaction id%s", id));
    }
}
