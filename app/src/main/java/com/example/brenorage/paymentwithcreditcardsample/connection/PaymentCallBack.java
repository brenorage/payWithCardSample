package com.example.brenorage.paymentwithcreditcardsample.connection;

import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;
import com.example.brenorage.paymentwithcreditcardsample.presenter.PaymentPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentCallBack implements Callback<PaymentTransaction> {

    private PaymentPresenter paymentPresenter;

    public PaymentCallBack(PaymentPresenter paymentPresenter){
        this.paymentPresenter = paymentPresenter;
    }

    @Override
    public void onResponse(Call call, Response response) {
        if(response.isSuccessful()) {
            paymentPresenter.onConnectionSuccess(response.code(), response.body());
        }
        else {
            paymentPresenter.onConnectionError(response.code(), response.errorBody());
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        paymentPresenter.onConnectionFail(t);
    }
}
