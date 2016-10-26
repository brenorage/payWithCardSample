package com.example.brenorage.paymentwithcreditcardsample.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.brenorage.paymentwithcreditcardsample.Util.adapters.HistoryAdapterRecyclerView;
import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;

import java.util.List;

public class HistoryPresenter {

    public HistoryPresenter() {}

    private List<PaymentTransaction> getTransactionList() {
        return PaymentTransaction.listAll(PaymentTransaction.class);
    }

    public HistoryAdapterRecyclerView getAdapter() {
        return new HistoryAdapterRecyclerView(getTransactionList());
    }
}
