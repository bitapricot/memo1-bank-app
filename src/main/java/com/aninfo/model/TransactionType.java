package com.aninfo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionType {
    public static final int DEPOSIT_ID = 1;
    public static final int WITHDRAWAL_ID = 2;

    @Id
    private int id;
    private String description;

    public boolean isWithdrawal() {
        return id == WITHDRAWAL_ID;
    }

    public boolean isDeposit() {
        return id == DEPOSIT_ID;
    }
}


