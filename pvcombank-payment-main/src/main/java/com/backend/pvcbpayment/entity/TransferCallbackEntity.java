package com.backend.pvcbpayment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "tbl_transfer_callback")
public class TransferCallbackEntity {

    @Id
    @Column(name ="id")
    private int id;
    @Column(name ="ft_type")
    private String ftType;
    @Column(name ="amount")
    private Long amount;
    @Column(name ="balance")
    private Long balance;
    @Column(name ="sender_bankId")
    private String senderBankId;
    @Column(name ="description")
    private String description;
    @Column(name ="tranId")
    private String tranId;
    @Column(name ="dateTime")
    private String dateTime;
    @Column(name ="currency")
    private String currency;
    @Column(name ="tran_status")
    private String tranStatus;
    @Column(name ="con_amount")
    private String conAmount;
    @Column(name ="number_of_beneficiary")
    private String numberOfBeneficiary;
    @Column(name ="account")
    private String account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
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
