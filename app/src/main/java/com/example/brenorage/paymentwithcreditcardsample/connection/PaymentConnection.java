package com.example.brenorage.paymentwithcreditcardsample.connection;

import com.example.brenorage.paymentwithcreditcardsample.Util.Constants;
import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PaymentConnection {

    public PaymentConnection() {}

    private Retrofit getRetrofitBuilder() {
        return new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public Call<PaymentTransaction> makeTransaction(PaymentTransaction paymentTransaction) throws Exception {

        PaymentService paymentService = getRetrofitBuilder().create(PaymentService.class);
        return paymentService.makeTransaction(paymentTransaction);
    }
}
