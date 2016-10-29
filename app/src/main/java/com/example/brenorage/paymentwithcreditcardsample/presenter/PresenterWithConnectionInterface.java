package com.example.brenorage.paymentwithcreditcardsample.presenter;

import okhttp3.ResponseBody;

public interface PresenterWithConnectionInterface {

    void onConnectionSuccess(int statusCode, Object body);
    void onConnectionError(int statusCode, ResponseBody responseBody);
    void onConnectionFail(Throwable t);
}
