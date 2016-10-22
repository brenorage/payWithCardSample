package com.example.brenorage.paymentwithcreditcardsample.connection;

import android.content.Context;

import com.example.brenorage.paymentwithcreditcardsample.Util.Constants;
import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PaymentConnection {

    public PaymentConnection() {}

    private Retrofit getRetrofitBuilder() {
        return new Retrofit.Builder().baseUrl(Constants.BASE_URL).build();
    }

    public Call makeTransaction(PaymentTransaction paymentTransaction) throws Exception {

        PaymentService paymentService = getRetrofitBuilder().create(PaymentService.class);
        return paymentService.makeTransaction(paymentTransaction);
    }
}
