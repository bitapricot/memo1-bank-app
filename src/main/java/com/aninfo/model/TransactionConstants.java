package com.aninfo.model;


public enum TransactionConstants {

    DEPOSIT_SUM_PROMO(2000.0),
    DEPOSIT_EXTRA_PERCENTAGE(0.1),
    DEPOSIT_EXTRA_MAX_AMOUNT(500.0);

    private Double value;

    TransactionConstants(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

}