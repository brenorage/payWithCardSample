package com.example.brenorage.paymentwithcreditcardsample.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.brenorage.paymentwithcreditcardsample.Util.Constants;
import com.example.brenorage.paymentwithcreditcardsample.connection.PaymentCallBack;
import com.example.brenorage.paymentwithcreditcardsample.connection.PaymentConnection;
import com.example.brenorage.paymentwithcreditcardsample.model.PaymentResult;
import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;
import com.example.brenorage.paymentwithcreditcardsample.view.ResultActivity;
import com.google.gson.Gson;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class PaymentPresenter {

    private Call call;
    private Activity activity;

    public PaymentPresenter(Activity activity) {
        this.activity = activity;
    }

    public void doTransaction(PaymentTransaction paymentTransaction, Context context) {
        try {
            paymentTransaction.save();
            Call call = getCall(paymentTransaction);
            call.execute();
            call.enqueue(new PaymentCallBack(this));
        }
        catch (Exception e){
            //
        }
    }

    public void onConnectionSuccess(int statusCode, Object body) {
        if(statusCode == Constants.CONN_RESULT_OK) {
            Intent intent = new Intent(activity, ResultActivity.class);
            activity.startActivityForResult(intent, Constants.RESULT_OK);
        }
    }

    public void onConnectionError(int statusCode, ResponseBody responseBody) {
        Intent intent = new Intent(activity, ResultActivity.class);
        switch (statusCode) {
            case Constants.CONN_NOT_FOUND:
                activity.startActivityForResult(intent, Constants.RESULT_ERROR_404);
                break;
            case Constants.CONN_INTERNAL_ERROR:
                Intent intent2 = new Intent(activity, ResultActivity.class);
                activity.startActivityForResult(intent2, Constants.RESULT_ERROR_500);
                break;
        }
    }

    public void onConnectionFail(Throwable t) {

    }

    private Call getCall(PaymentTransaction paymentTransaction) throws Exception {
        PaymentConnection paymentConnection = new PaymentConnection();
        return paymentConnection.makeTransaction(paymentTransaction);
    }
}
