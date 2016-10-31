package com.example.brenorage.paymentwithcreditcardsample.Util.holders;


import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.brenorage.paymentwithcreditcardsample.R;

public class HistoryRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView amount;
    public TextView cardNumber;
    public TextView status;

    public HistoryRecyclerViewHolder(LinearLayout layoutItem) {
        super(layoutItem);

        name = (TextView) layoutItem.findViewById(R.id.nameEditText);
        amount = (TextView) layoutItem.findViewById(R.id.amountEditText);
        cardNumber = (TextView) layoutItem.findViewById(R.id.creditCardTextView);
        status = (TextView) layoutItem.findViewById(R.id.statusTextView);
    }

}
