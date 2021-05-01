package com.redbird.SaldoBack.controllers;

import com.redbird.SaldoBack.models.Transaction;
import com.redbird.SaldoBack.services.TransactionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    @GetMapping("/admin/{id}")
    @PreAuthorize("hasAuthority('permission:admin')")
    public Transaction getById(@PathVariable("id") Long id) {
        return transactionService.getById(id);
    }

    /**
     * Endpoint to get all transactions
     * @return List of all transactions
     */
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('permission:admin')")
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }

    /**
     * Endpoint to save transaction
     * @param transaction - transaction to save
     * @return Saved transaction
     */
    @PostMapping()
    @PreAuthorize("hasAuthority('permission:user')")
    public Transaction save(@RequestBody Transaction transaction, Principal principal) {
        return transactionService.save(transaction, principal.getName());
    }

    /**
     * Endpoint to delete transaction
     * @param id - id of transaction
     */
    @DeleteMapping("/admin/{id}")
    @PreAuthorize("hasAuthority('permission:admin')")
    public void delete(@PathVariable("id") Long id) {
        transactionService.delete(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('permission:user')")
    public void deleteByUser(@PathVariable("id") Long id, Principal principal) {
        transactionService.deleteByUser(id, principal.getName());
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('permission:user')")
    public List<Transaction> getAllByUser(Principal principal) {
        return transactionService.getAllByUser(principal.getName());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('permission:user')")
    public Transaction getByIdByUser(@PathVariable Long id, Principal principal) {
        return transactionService.getByIdByUser(id, principal.getName());
    }
}
