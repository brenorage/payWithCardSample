package com.example.brenorage.paymentwithcreditcardsample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.brenorage.paymentwithcreditcardsample.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
