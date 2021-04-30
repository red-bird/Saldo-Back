package com.redbird.SaldoBack.controllers;

import com.redbird.SaldoBack.models.Transaction;
import com.redbird.SaldoBack.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class for transaction entities
 */
@RestController
@RequestMapping("api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Endpoint to get transaction by id
     * @param id - id of transaction
     * @return Transaction object
     */
    @GetMapping("/{id}")
    public Transaction getById(@PathVariable("id") Long id) {
        return transactionService.getById(id);
    }

    /**
     * Endpoint to get all transactions
     * @return List of all transactions
     */
    @GetMapping()
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }

    /**
     * Endpoint to save transaction
     * @param transaction - transaction to save
     * @return Saved transaction
     */
    @PostMapping()
    public Transaction save(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    /**
     * Endpoint to delete transaction
     * @param id - id of transaction
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        transactionService.delete(id);
    }

}
