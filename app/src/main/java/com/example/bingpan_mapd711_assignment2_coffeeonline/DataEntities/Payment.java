package com.example.bingpan_mapd711_assignment2_coffeeonline.DataEntities;

public class Payment {
    private Customer customer;
    private String cardType = "";
    private String cardNumber = "";
    private String expiryDate = "";
    private String cardVerificationCode = "";



    public Payment() {
        this.customer = null;
        this.cardType = "";
        this.cardNumber = "";
        this.expiryDate = "";
        this.cardVerificationCode = "";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardVerificationCode() {
        return cardVerificationCode;
    }

    public void setCardVerificationCode(String cardVerificationCode) {
        this.cardVerificationCode = cardVerificationCode;
    }
}
