package com.example.brenorage.paymentwithcreditcardsample.model;

public class PaymentTransaction {

    private String ownerName;
    private String cardNumber;
    private String yearValid;
    private String monthValid;
    private String brand;
    private String cvv;
    private String amount;

    public PaymentTransaction() {}

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getYearValid() {
        return yearValid;
    }

    public void setYearValid(String yearValid) {
        this.yearValid = yearValid;
    }

    public String getMonthValid() {
        return monthValid;
    }

    public void setMonthValid(String monthValid) {
        this.monthValid = monthValid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
