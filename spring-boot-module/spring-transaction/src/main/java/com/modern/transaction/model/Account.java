package com.modern.transaction.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long Id;
    @Column
    private String name;
    @Column
    private BigDecimal amount;

    public Account(Long id, String name, BigDecimal amount) {
        Id = id;
        this.name = name;
        this.amount = amount;
    }

    public Account() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
