package com.backend.pvcbpayment.model;


public class FundTransferRequest {
    private String paymentId;
    private FundTransferType ftType;
    private String numberOfBeneficial;
    private long amount;
    private String description;
    private String bankId;

    public FundTransferRequest(String paymentId, FundTransferType ftType, String numberOfBeneficial, long amount, String description, String bankId) {
        this.paymentId = paymentId;
        this.ftType = ftType;
        this.numberOfBeneficial = numberOfBeneficial;
        this.amount = amount;
        this.description = description;
        this.bankId = bankId;
    }

    public static class FundTransferRequestBuilder {
        private String paymentId;
        private FundTransferType ftType;
        private String numberOfBeneficial;
        private long amount;
        private String description;
        private String bankId;

        public FundTransferRequestBuilder(String paymentId, FundTransferType ftType, String numberOfBeneficial, long amount, String description, String bankId) {
            this.paymentId = paymentId;
            this.ftType = ftType;
            this.numberOfBeneficial = numberOfBeneficial;
            this.amount = amount;
            this.bankId = bankId;
        }

        public FundTransferRequestBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public FundTransferRequest build() {
            FundTransferRequest fundTransferRequest = new FundTransferRequest(
                    this.paymentId,this.ftType,this.numberOfBeneficial,this.amount,this.description,this.bankId
            );
            return fundTransferRequest;
        }
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setFtType(FundTransferType ftType) {
        this.ftType = ftType;
    }

    public void setNumberOfBeneficial(String numberOfBeneficial) {
        this.numberOfBeneficial = numberOfBeneficial;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public FundTransferType getFtType() {
        return ftType;
    }

    public String getNumberOfBeneficial() {
        return numberOfBeneficial;
    }

    public long getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getBankId() {
        return bankId;
    }
}
