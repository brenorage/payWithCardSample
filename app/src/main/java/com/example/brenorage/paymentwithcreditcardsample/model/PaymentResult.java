package com.example.brenorage.paymentwithcreditcardsample.model;

import com.google.gson.annotations.SerializedName;

public class PaymentResult {

    private String message;
    private String transactionId;

    public PaymentResult(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
