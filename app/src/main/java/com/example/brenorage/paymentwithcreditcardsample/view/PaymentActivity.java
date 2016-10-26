package com.example.brenorage.paymentwithcreditcardsample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.brenorage.paymentwithcreditcardsample.R;
import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;
import com.example.brenorage.paymentwithcreditcardsample.presenter.PaymentPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentActivity extends AppCompatActivity {

    @BindView(R.id.amountTextView)
    EditText amountEditText;

    @BindView(R.id.nameTextView)
    EditText nameTextView;

    @BindView(R.id.cardNumberTextView)
    EditText cardNumberTextView;

    @BindView(R.id.cvvTextView)
    EditText cvvTextView;

    @BindView(R.id.monthTextView)
    EditText monthTextView;

    @BindView(R.id.yearTextView)
    EditText yearTextView;

    PaymentPresenter paymentPresenter;
    PaymentTransaction paymentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @OnClick(R.id.paymentButton)
    public void confirmAction() {
        fillPaymentTransaction();
        paymentTransaction = new PaymentTransaction();
        paymentPresenter = new PaymentPresenter(this);
        paymentPresenter.doTransaction(paymentTransaction);
    }

    private void fillPaymentTransaction() {
        String amount = amountEditText.getText().toString();
        String name = nameTextView.getText().toString();
        String cardNumber = cardNumberTextView.getText().toString();
        String cvv = cvvTextView.getText().toString();
        String month = monthTextView.getText().toString();
        String year = yearTextView.getText().toString();

        if(amount.isEmpty()) {
            amountEditText.setError(getString(R.string.empty_field));
        }
        else if(name.isEmpty()) {
            nameTextView.setError(getString(R.string.empty_field));
        }
        else if(cardNumber.isEmpty()) {
            cardNumberTextView.setError(getString(R.string.empty_field));
        }
        else if(cvv.isEmpty()) {
            cvvTextView.setError(getString(R.string.empty_field));
        }
        else if(month.isEmpty()) {
            monthTextView.setError(getString(R.string.empty_field));
        }
        else if(year.isEmpty()) {
            yearTextView.setError(getString(R.string.empty_field));
        }
        else {
            paymentTransaction.setAmount(amount);
            paymentTransaction.setOwnerName(name);
            paymentTransaction.setCardNumber(cardNumber);
            paymentTransaction.setCvv(cvv);
            paymentTransaction.setMonthValid(month);
            paymentTransaction.setYearValid(year);
        }
    }
}
