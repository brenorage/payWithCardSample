package com.example.brenorage.paymentwithcreditcardsample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.brenorage.paymentwithcreditcardsample.R;
import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;
import com.example.brenorage.paymentwithcreditcardsample.presenter.PaymentPresenter;

public class PaymentActivity extends AppCompatActivity {

    PaymentPresenter paymentPresenter;
    PaymentTransaction paymentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void confirmAction() {
        paymentTransaction = new PaymentTransaction();
        paymentPresenter = new PaymentPresenter(this);
        paymentPresenter.doTransaction(paymentTransaction);
    }
}
