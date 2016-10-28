package com.example.brenorage.paymentwithcreditcardsample.presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.example.brenorage.paymentwithcreditcardsample.R;
import com.example.brenorage.paymentwithcreditcardsample.Util.Constants;
import com.example.brenorage.paymentwithcreditcardsample.connection.PaymentCallBack;
import com.example.brenorage.paymentwithcreditcardsample.connection.PaymentConnection;
import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class PaymentPresenter {

    private Activity activity;

    public PaymentPresenter(Activity activity) {
        this.activity = activity;
    }

    public void doTransaction(PaymentTransaction paymentTransaction) {
        try {
            paymentTransaction.save();
            Call<PaymentTransaction> call = getCall(paymentTransaction);
            call.enqueue(new PaymentCallBack(this));
        }
        catch (Exception e){
            onConnectionFail(e.getCause());
        }
    }

    public void onConnectionSuccess(int statusCode, Object body) {
        if(statusCode == Constants.CONN_RESULT_OK) {
            createAlertDialog(activity.getString(android.R.string.ok),
                    activity.getString(R.string.success_payment));
        }
    }

    public void onConnectionError(int statusCode, ResponseBody responseBody) {
        switch (statusCode) {
            case Constants.CONN_NOT_FOUND:
                createAlertDialog(activity.getString(android.R.string.ok),
                        activity.getString(R.string.generic_error_payment));
                break;
            case Constants.CONN_INTERNAL_ERROR:
                createAlertDialog(activity.getString(android.R.string.ok),
                        activity.getString(R.string.generic_error_payment));
                break;
        }
    }

    public void onConnectionFail(Throwable t) {
        createAlertDialog(activity.getString(android.R.string.ok),
                activity.getString(R.string.generic_error_payment));
    }

    public boolean isValidMonth(String month) {
        if(!month.isEmpty()) {
            int monthInt = Integer.valueOf(month);
            if(monthInt > 0 && monthInt < 13) {
               return true;
            }
        }
        return false;
    }

    public boolean isValidYear(String year) {
        if(!year.isEmpty()) {
            int yearInt = Integer.valueOf(year);
            if(year.length() == 4 && yearInt > 2015) {
                return true;
            }
        }
        return false;
    }

    private void createAlertDialog(String buttonOk, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message);
        builder.setPositiveButton(buttonOk, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                activity.finish();
            }
        });
        builder.create();
        builder.show();
    }

    private Call<PaymentTransaction> getCall(PaymentTransaction paymentTransaction) throws Exception {
        PaymentConnection paymentConnection = new PaymentConnection();
        return paymentConnection.makeTransaction(paymentTransaction);
    }
}
