package com.example.brenorage.paymentwithcreditcardsample.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.brenorage.paymentwithcreditcardsample.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.mainPayButton)
    public void payAction() {
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.historyButton)
    public void historyAction() {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
}
