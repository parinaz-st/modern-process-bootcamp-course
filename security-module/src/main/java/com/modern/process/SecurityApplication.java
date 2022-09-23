package com.modern.process;

import com.modern.process.domain.User;
import com.modern.process.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner
{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepo.save(new User("pari", passwordEncoder.encode("123456") , "ADMIN"));

    }
}
