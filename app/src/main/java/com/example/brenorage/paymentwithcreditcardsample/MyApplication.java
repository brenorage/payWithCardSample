package com.example.brenorage.paymentwithcreditcardsample;

import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;
import com.orm.SugarApp;
import com.orm.SugarContext;

public class MyApplication extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
        PaymentTransaction.findById(PaymentTransaction.class, (long) 1);
    }
}
