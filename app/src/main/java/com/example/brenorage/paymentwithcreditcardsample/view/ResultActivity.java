package com.example.brenorage.paymentwithcreditcardsample.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.brenorage.paymentwithcreditcardsample.R;
import com.example.brenorage.paymentwithcreditcardsample.Util.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ok_button)
    public void okAction() {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode) {
            case Constants.RESULT_OK:
                break;
            case Constants.RESULT_ERROR_404:
                break;
            case Constants.RESULT_ERROR_500:
                break;
        }
    }
}
