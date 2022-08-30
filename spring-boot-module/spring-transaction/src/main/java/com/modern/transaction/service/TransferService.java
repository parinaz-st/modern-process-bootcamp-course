package com.modern.transaction.service;

import com.modern.transaction.model.Account;
import com.modern.transaction.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    @Autowired
    AccountRepository accountRepository;

    public void  transferMoney(long idSender, long idReseiver, BigDecimal amount)
    {
        Account sender = accountRepository.findById(idSender).orElse(null);
        Account reciever = accountRepository.findById(idReseiver).orElse(null);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal recieverNewAmount = reciever.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReseiver, recieverNewAmount);

    }
    public List<Account> getAllAccounts()
    {
        return accountRepository.findAll();
    }
}
