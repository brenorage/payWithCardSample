package com.example.brenorage.paymentwithcreditcardsample.presenter;

import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;

import java.util.List;

public class HistoryPresenter {

    public HistoryPresenter() {}

    private List<PaymentTransaction> getTransactionList() {
        return PaymentTransaction.listAll(PaymentTransaction.class);
    }
}
