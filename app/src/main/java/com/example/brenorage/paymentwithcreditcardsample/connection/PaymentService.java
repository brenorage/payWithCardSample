package com.example.brenorage.paymentwithcreditcardsample.connection;

import com.example.brenorage.paymentwithcreditcardsample.model.PaymentTransaction;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PaymentService {
    @POST("/pay")
    Call<Void> makeTransaction(@Body PaymentTransaction transaction);
}
