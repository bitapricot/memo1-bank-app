package com.aninfo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private Double amount;
    @ManyToOne
    private Account account;
    private LocalDateTime date = LocalDateTime.now();

    public Transaction() {
    }

    public Transaction(String type, Double amount, Account account) {
        this.type = type;
        this.amount = amount;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
