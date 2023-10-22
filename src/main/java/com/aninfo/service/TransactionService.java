package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Account;
import com.aninfo.model.Transaction;
import com.aninfo.model.TransactionType;
import com.aninfo.repository.TransactionRepository;
import com.aninfo.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createWithdraw(Double sum, Account account) {
        // Validate that the transaction is not greater than the account balance in case of withdrawal
        if (sum.compareTo(account.getBalance()) > 0) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        TransactionType withdrawalType = transactionTypeRepository.findById(TransactionType.WITHDRAWAL_ID).get();
        Transaction transaction = new Transaction(withdrawalType, sum, account);

        return transactionRepository.save(transaction);
    }

    public Transaction createDeposit(Double sum, Account account) {
        // Validate that amount is not null
        if (sum <= 0) {
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        }

        TransactionType depositType = transactionTypeRepository.findById(TransactionType.DEPOSIT_ID).get();
        Transaction transaction = new Transaction(depositType, sum, account);

        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> findById(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public Collection<Transaction> findAllByAccount(Long cbu) {
        return transactionRepository.findAllByAccount_Cbu(cbu);
    }

    public void deleteById(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }
}
