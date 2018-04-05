package com.example.ahmetserdargeze.koinplusapp.retrofit;

import com.example.ahmetserdargeze.koinplusapp.RegisterationPojo;
import com.example.ahmetserdargeze.koinplusapp.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    @GET("top25/{kur_type}/")
    Call<Result> getCoinWithType(@Path("kur_type") String kur_type);
//    void  getCoinWithType(@Path("kur_type") String kur_type, Callback<Result>cb);

}
