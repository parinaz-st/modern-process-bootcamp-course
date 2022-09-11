package com.modern.transaction.service;

import com.modern.transaction.model.Account;
import com.modern.transaction.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    @Autowired
    AccountRepository accountRepository;

    @Transactional(rollbackFor = Exception.class)
    public void  transferMoney(long idSender, long idReseiver, BigDecimal amount) throws FileNotFoundException {
        try
        {
            Account sender = accountRepository.findById(idSender).orElse(null);
            Account reciever = accountRepository.findById(idReseiver).orElse(null);

            BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
            BigDecimal recieverNewAmount = reciever.getAmount().add(amount);

            accountRepository.changeAmount(idSender, senderNewAmount);
            accountRepository.changeAmount(idReseiver, recieverNewAmount);

//runtime
//            throw new RuntimeException("Something Wicked This Way Comes...");

            //not runtime
            throw new FileNotFoundException("Something Wicked This Way Comes...");

        }
        catch (Exception ex)
        {
//            throw new RuntimeException("Something Wicked This Way Comes...");
            throw new FileNotFoundException("Something Wicked This Way Comes...");

        }
    }
    public List<Account> getAllAccounts()
    {
        return accountRepository.findAll();
    }
}
