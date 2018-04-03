package com.example.ahmetserdargeze.koinplusapp.retrofit;

import com.example.ahmetserdargeze.koinplusapp.RegisterationPojo;
import com.example.ahmetserdargeze.koinplusapp.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ahmetserdargeze on 08.03.2018.
 */

public interface APIService {
    @POST("register/")
    @FormUrlEncoded
    Call<RegisterationPojo> saveUser(
            @Field("username") String username,
            @Field("email")    String email,
            @Field("password") String password,
            @Field("confirm_password") String confirm_password);


    @GET("returnTop25")
    Call<Result> getTop25();
}
