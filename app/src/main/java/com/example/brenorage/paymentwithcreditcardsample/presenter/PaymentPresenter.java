package com.example.brenorage.paymentwithcreditcardsample.presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;

import com.example.brenorage.paymentwithcreditcardsample.R;
import com.example.brenorage.paymentwithcreditcardsample.Util.Constants;
import com.example.brenorage.paymentwithcreditcardsample.connection.PaymentCallBack;
import com.example.brenorage.paymentwithcreditcardsample.connection.PaymentConnection;
import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class PaymentPresenter implements PresenterWithConnectionInterface {

    private Activity activity;
    private ProgressDialog progressDialog;
    private PaymentTransaction paymentTransaction;

    public PaymentPresenter(Activity activity) {
        this.activity = activity;
    }

    public void doTransaction(PaymentTransaction paymentTransaction) {
        try {
            this.paymentTransaction = paymentTransaction;
            progressDialog = new ProgressDialog(activity);
            progressDialog.setMessage(activity.getString(R.string.wait_transaction));
            progressDialog.show();
            paymentTransaction.save();
            Call<Void> call = getCall(paymentTransaction);
            call.enqueue(new PaymentCallBack(this));
        }
        catch (Exception e){
            onConnectionFail(e.getCause());
        }
    }

    public void onConnectionSuccess(int statusCode, Object body) {
        progressDialog.cancel();
        if(statusCode == Constants.CONN_RESULT_OK) {
            updatePaymentTransaction("aprovado");
            createAlertDialog(activity.getString(android.R.string.ok),
                    activity.getString(R.string.success_payment));
        }
        else {
            updatePaymentTransaction("reprovado");
        }
    }

    public void onConnectionError(int statusCode, ResponseBody responseBody) {
        progressDialog.cancel();
        updatePaymentTransaction("reprovado");
        switch (statusCode) {
            case Constants.CONN_NOT_FOUND:
                createAlertDialog(activity.getString(android.R.string.ok),
                        activity.getString(R.string.generic_error_payment));
                break;
            case Constants.CONN_INTERNAL_ERROR:
                updatePaymentTransaction("reprovado");
                createAlertDialog(activity.getString(android.R.string.ok),
                        activity.getString(R.string.generic_error_payment));
                break;
        }
    }

    public void onConnectionFail(Throwable t) {
        progressDialog.cancel();
        updatePaymentTransaction("reprovado");
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

    private void updatePaymentTransaction(String status) {
        PaymentTransaction newPaymentTransaction = PaymentTransaction.findById(PaymentTransaction.class, paymentTransaction.getId());
        newPaymentTransaction.setStatus(status);
        newPaymentTransaction.save();
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

    private Call<Void> getCall(PaymentTransaction paymentTransaction) throws Exception {
        PaymentConnection paymentConnection = new PaymentConnection();
        return paymentConnection.makeTransaction(paymentTransaction);
    }
}
