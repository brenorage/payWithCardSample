package com.example.brenorage.paymentwithcreditcardsample.Util.watchers;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.NumberFormat;

public class TextWatcherForCurrencyFormat implements TextWatcher {

    private String currentString = "";
    private EditText mEditText;

    public TextWatcherForCurrencyFormat(EditText mEditText) {
        this.mEditText = mEditText;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(!charSequence.toString().equals(currentString)){
            mEditText.removeTextChangedListener(this);

            String cleanString = charSequence.toString().replaceAll("[$,.]", "");

            double parsed = Double.parseDouble(cleanString);
            String formatted = NumberFormat.getCurrencyInstance().format((parsed/100));

            currentString = formatted;
            mEditText.setText(formatted);
            mEditText.setSelection(formatted.length());

            mEditText.addTextChangedListener(this);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
