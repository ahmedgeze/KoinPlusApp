package com.example.ahmetserdargeze.koinplusapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.ahmetserdargeze.koinplusapp.Fragments.Global_market_fragment;
import com.example.ahmetserdargeze.koinplusapp.models.Global_state_var;
import com.example.ahmetserdargeze.koinplusapp.models.Result;
import com.example.ahmetserdargeze.koinplusapp.retrofit.APIService;
import com.example.ahmetserdargeze.koinplusapp.retrofit.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ahmetserdargeze on 18.04.2018.
 */

public class ActivityGlobal extends AppCompatActivity {
    LinearLayout marketll,profilell,tradell,settingsll;

    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("http://192.168.1.9:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public void changeColorBottom(int active_bottom){
        switch (active_bottom){
            case 0:
                marketll.setBackgroundColor(getResources().getColor(R.color.topBarSelected,getApplicationContext().getTheme()));
                profilell.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                tradell.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                settingsll.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                loadFragment(new Global_market_fragment(),R.id.global_container);
                break;
            case 1:
                marketll.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                profilell.setBackgroundColor(getResources().getColor(R.color.topBarSelected,getApplicationContext().getTheme()));
                tradell.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                settingsll.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                break;
            case 2:
                marketll.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                profilell.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                tradell.setBackgroundColor(getResources().getColor(R.color.topBarSelected,getApplicationContext().getTheme()));
                settingsll.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                break;

            case 3:
                marketll.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                profilell.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                tradell.setBackgroundColor(getResources().getColor(R.color.layout_bg,getApplicationContext().getTheme()));
                settingsll.setBackgroundColor(getResources().getColor(R.color.topBarSelected,getApplicationContext().getTheme()));
                break;


        }



    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);





        marketll=(LinearLayout) findViewById(R.id.market_button);
        profilell=(LinearLayout) findViewById(R.id.account_button);
        tradell=(LinearLayout) findViewById(R.id.trade_button);
        settingsll=(LinearLayout) findViewById(R.id.settings_button);


        changeColorBottom(Global_state_var.getBottombar_state());

        marketll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global_state_var.setBottombar_state(0);
                changeColorBottom(Global_state_var.getBottombar_state());
            }
        });

        profilell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global_state_var.setBottombar_state(1);
                changeColorBottom(Global_state_var.getBottombar_state());
            }
        });

        tradell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global_state_var.setBottombar_state(2);
                changeColorBottom(Global_state_var.getBottombar_state());
            }
        });

        settingsll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global_state_var.setBottombar_state(3);
                changeColorBottom(Global_state_var.getBottombar_state());
            }
        });






    }
















    public  void loadFragment(Fragment fragment, int container){
        FragmentManager fm=getFragmentManager();

        FragmentTransaction fragmentTransaction=fm.beginTransaction();

        fragmentTransaction.replace(container,fragment);

        fragmentTransaction.commit();



    }
}
