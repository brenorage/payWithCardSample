package com.example.brenorage.paymentwithcreditcardsample.controller;

import com.example.brenorage.paymentwithcreditcardsample.connection.PaymentConnection;
import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentController {

    private Call call;

    public PaymentController(PaymentTransaction paymentTransaction) throws Exception {
        call = getCall(paymentTransaction);
    }

    private Call getCall(PaymentTransaction paymentTransaction) throws Exception {

        PaymentConnection paymentConnection = new PaymentConnection();
        return paymentConnection.makeTransaction(paymentTransaction);
    }

//    public Callback getResponseCode() throws Exception {
//        return call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//
//            }
//        }
//    }
//
//    public ResponseBody getErrorBody() {
//        return call.errorBody();
//    }
}
