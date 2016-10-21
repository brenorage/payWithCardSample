package com.example.brenorage.paymentwithcreditcardsample.connection;

import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;

import retrofit2.Retrofit;

public class PaymentConnection {

    public PaymentConnection() {
    }

    private Retrofit getRetrofitBuilder() {
        return new Retrofit.Builder().baseUrl("").build();
    }

    public int makeTransaction(PaymentTransaction paymentTransaction) {
        PaymentService paymentService = getRetrofitBuilder().create(PaymentService.class);
        paymentService.makeTransaction(paymentTransaction);
        return 0;
    }
}
