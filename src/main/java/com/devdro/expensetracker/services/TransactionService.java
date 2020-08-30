package com.devdro.expensetracker.services;


import java.util.List;

import com.devdro.expensetracker.domain.Transaction;
import com.devdro.expensetracker.exceptions.EtBadRequestException;
import com.devdro.expensetracker.exceptions.EtResourceNotFoundException;

public interface TransactionService {

    List<Transaction> fetchAllTransactions(Integer userId, Integer categoryid);

    Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId)
            throws EtBadRequestException;

    Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException;

    void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction)
            throws EtBadRequestException;

    void removeTransaction(Integer userId, Integer categoryId, Integer transactionId)
            throws EtResourceNotFoundException;

}
