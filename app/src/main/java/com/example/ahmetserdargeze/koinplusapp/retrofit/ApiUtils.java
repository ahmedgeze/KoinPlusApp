package com.example.ahmetserdargeze.koinplusapp.retrofit;

/**
 * Created by ahmetserdargeze on 08.03.2018.
 */

public class ApiUtils {
    private ApiUtils(){}
    public static final String BASE_URL="http://192.168.1.9:8080/";
    public static  APIService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);

    }
}
