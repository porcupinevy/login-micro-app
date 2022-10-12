package com.backend.pvcbpayment.entity;

import com.backend.pvcbpayment.model.FundTransferType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_fund_transfer_request")
public class FundTransferRequestEntity {
    @Id
    @Column(name ="id")
    private int id;
    @Column(name ="payment_id")
    private String paymentId;
    @Column(name ="ft_type")
    private FundTransferType ftType;
    @Column(name ="number_of_beneficial")
    private String numberOfBeneficial;
    @Column(name ="amount")
    private Double amount;
    @Column(name ="description")
    private String description;
    @Column(name ="bank_id")
    private String bankId;
    @Column(name ="status")
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public FundTransferType getFtType() {
        return ftType;
    }

    public void setFtType(FundTransferType ftType) {
        this.ftType = ftType;
    }

    public String getNumberOfBeneficial() {
        return numberOfBeneficial;
    }

    public void setNumberOfBeneficial(String numberOfBeneficial) {
        this.numberOfBeneficial = numberOfBeneficial;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
