package com.modern.transaction.controller;

import com.modern.transaction.dto.TransferRequestDto;
import com.modern.transaction.model.Account;
import com.modern.transaction.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    TransferService transferService;

    @PostMapping("/Transfer")
    public void transferMoney(@RequestBody TransferRequestDto request) throws FileNotFoundException {
        transferService.transferMoney(request.getSernderAccountId(), request.getRecieverAccountId(), request.getAmount());
    }


    @GetMapping("/Accounts")
    public List<Account> getAllAccounts()
    {
        return transferService.getAllAccounts();
    }

}
