package com.aninfo.model;

public enum TransactionType {

    DEPOSIT("DEPOSIT"),
    WITHDRAWAL("WITHDRAWAL");

    private String value;

    TransactionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
