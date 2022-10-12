package com.backend.pvcbpayment.model;

import java.text.SimpleDateFormat;

class TransferCallbackParams {

    private String ftType;
    private Long amount;
    private Long balance;
    private String senderBankId;
    private String description;
    private String tranId;
    private SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String currency;
    private String tranStatus;
    private String conAmount;
    private String numberOfBeneficiary;
    private String account;

    public TransferCallbackParams(String ftType, Long amount, Long balance, String senderBankId, String description, String tranId, SimpleDateFormat dateTime, String currency, String tranStatus, String conAmount, String numberOfBeneficiary, String account) {
        this.ftType = ftType;
        this.amount = amount;
        this.balance = balance;
        this.senderBankId = senderBankId;
        this.description = description;
        this.tranId = tranId;
        this.dateTime = dateTime;
        this.currency = currency;
        this.tranStatus = tranStatus;
        this.conAmount = conAmount;
        this.numberOfBeneficiary = numberOfBeneficiary;
        this.account = account;
    }

    public String getFtType() {
        return ftType;
    }

    public void setFtType(String ftType) {
        this.ftType = ftType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getSenderBankId() {
        return senderBankId;
    }

    public void setSenderBankId(String senderBankId) {
        this.senderBankId = senderBankId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    public SimpleDateFormat getDateTime() {
        return dateTime;
    }

    public void setDateTime(SimpleDateFormat dateTime) {
        this.dateTime = dateTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }

    public String getConAmount() {
        return conAmount;
    }

    public void setConAmount(String conAmount) {
        this.conAmount = conAmount;
    }

    public String getNumberOfBeneficiary() {
        return numberOfBeneficiary;
    }

    public void setNumberOfBeneficiary(String numberOfBeneficiary) {
        this.numberOfBeneficiary = numberOfBeneficiary;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


}