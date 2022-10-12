package com.backend.pvcbpayment.model;

public class Bank {
    private final int bankId;
    private final String bankName;

    public Bank(int bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
    }

    public int getBankId() {
        return bankId;
    }

    public String getBankName() {
        return bankName;
    }

}
