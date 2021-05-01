package com.redbird.SaldoBack.servicesImpl;

import com.redbird.SaldoBack.models.Transaction;
import com.redbird.SaldoBack.models.User;
import com.redbird.SaldoBack.services.TransactionService;
import com.redbird.SaldoBack.services.UserService;
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
    private final UserService userService;

    public TransactionServiceImpl(TransactionRepo transactionRepo, UserService userService) {
        this.transactionRepo = transactionRepo;
        this.userService = userService;
    }


    /**
     * Get transaction by it's id
     * @param id - unique number of transaction
     * @return Transaction object
     */
    @Override
    public Transaction getById(Long id) {
        Transaction transaction = transactionRepo.findById(id).orElse(null);
//        log.info(String.format("get %s"), transaction.toString());
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
    public Transaction save(Transaction transaction, String username) {
        transaction.setUser(userService.findByUsername(username));
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

    @Override
    public void deleteByUser(Long id, String username) {
        Transaction transaction = getById(id);
        if (username.equals(transaction.getUser().getUsername())) {
            transactionRepo.deleteById(id);
        }
    }

    @Override
    public Transaction getByIdByUser(Long id, String username) {
        Transaction transaction = getById(id);
        return username.equals(transaction.getUser().getUsername()) ? transaction : null;
    }

    @Override
    public List<Transaction> getAllByUser(String username) {
        User user = userService.findByUsername(username);
        return transactionRepo.findAllByUser(user);
    }
}
