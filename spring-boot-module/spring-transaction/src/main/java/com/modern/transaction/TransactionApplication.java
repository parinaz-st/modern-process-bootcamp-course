package com.modern.transaction;

import com.modern.transaction.model.Account;
import com.modern.transaction.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class TransactionApplication implements CommandLineRunner {


	@Autowired
	private AccountRepository accountRepository;
	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountRepository.save(new Account("user1", new BigDecimal(1000)));
		accountRepository.save(new Account("user2", new BigDecimal(2000)));
	}
}
