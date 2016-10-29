package com.example.brenorage.paymentwithcreditcardsample.connection;

import com.example.brenorage.paymentwithcreditcardsample.presenter.PresenterWithConnectionInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentCallBack implements Callback<Void> {

    private PresenterWithConnectionInterface interfacePresenter;

    public PaymentCallBack(PresenterWithConnectionInterface interfacePresenter){
        this.interfacePresenter = interfacePresenter;
    }

    @Override
    public void onResponse(Call call, Response response) {
        if(response.isSuccessful()) {
            interfacePresenter.onConnectionSuccess(response.code(), response.body());
        }
        else {
            interfacePresenter.onConnectionError(response.code(), response.errorBody());
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        interfacePresenter.onConnectionFail(t);
    }
}
