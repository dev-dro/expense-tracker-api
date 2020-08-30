package com.devdro.expensetracker.repositories;

import java.util.List;

import com.devdro.expensetracker.domain.Transaction;
import com.devdro.expensetracker.exceptions.EtBadRequestException;
import com.devdro.expensetracker.exceptions.EtResourceNotFoundException;

public interface TransactionRepository {

    List<Transaction> findAll(Integer userId, Integer categoryId);

    Transaction findById(Integer userId, Integer categoryId, Integer transactionid)
            throws EtResourceNotFoundException;

    Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate)
            throws EtBadRequestException;

    void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction)
            throws EtBadRequestException;

    void removeById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;
}
