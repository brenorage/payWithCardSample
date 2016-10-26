package com.example.brenorage.paymentwithcreditcardsample.Util.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.brenorage.paymentwithcreditcardsample.R;
import com.example.brenorage.paymentwithcreditcardsample.Util.holders.HistoryRecyclerViewHolder;
import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;

import java.util.List;

public class HistoryAdapterRecyclerView extends RecyclerView.Adapter<HistoryRecyclerViewHolder>{

    List<PaymentTransaction> paymentList;

    public HistoryAdapterRecyclerView(List<PaymentTransaction> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public HistoryRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_list_item, parent, false);

        return new HistoryRecyclerViewHolder((LinearLayout)itemView);
    }

    @Override
    public void onBindViewHolder(HistoryRecyclerViewHolder holder, int position) {

        PaymentTransaction paymentTransaction = paymentList.get(position);

        holder.name.setText(paymentTransaction.getOwnerName());
        holder.amount.setText("R$ ".concat(paymentTransaction.getAmount()));

        String cardNumberString = paymentTransaction.getCardNumber();
        holder.cardNumber.setText(cardNumberString.substring((cardNumberString.length() - 4)));
    }

    @Override
    public int getItemCount() {
        return paymentList.size();
    }
}
