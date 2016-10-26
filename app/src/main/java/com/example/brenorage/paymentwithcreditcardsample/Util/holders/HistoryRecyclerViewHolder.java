package com.example.brenorage.paymentwithcreditcardsample.Util.holders;


import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.brenorage.paymentwithcreditcardsample.R;

public class HistoryRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView amount;
    public TextView cardNumber;

    public HistoryRecyclerViewHolder(LinearLayout layoutItem) {
        super(layoutItem);

        name = (TextView) layoutItem.findViewById(R.id.nameTextView);
        amount = (TextView) layoutItem.findViewById(R.id.amountTextView);
        cardNumber = (TextView) layoutItem.findViewById(R.id.creditCardTextView);
    }

}
