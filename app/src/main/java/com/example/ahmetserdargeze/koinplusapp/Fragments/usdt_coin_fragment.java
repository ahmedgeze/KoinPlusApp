package com.example.ahmetserdargeze.koinplusapp.Fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ahmetserdargeze.koinplusapp.R;
import com.example.ahmetserdargeze.koinplusapp.models.ChildDataItem;
import com.example.ahmetserdargeze.koinplusapp.models.Result;
import com.example.ahmetserdargeze.koinplusapp.models.Rv_object_coin;
import com.example.ahmetserdargeze.koinplusapp.recylerview.MarketAdapter;
import com.example.ahmetserdargeze.koinplusapp.recylerview.ResultAdapter;
import com.example.ahmetserdargeze.koinplusapp.retrofit.APIService;
import com.example.ahmetserdargeze.koinplusapp.retrofit.ApiUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import  java.util.Random;

/**
 * Created by ahmetserdargeze on 10.03.2018.
 */

public class usdt_coin_fragment extends Fragment {
    LinearLayout onClickBTC;
    LinearLayout onClickUSDT;
    LinearLayout onClickETH;


    public APIService usdToCoin;
    public APIService btcToCoin;
    public APIService ethToCoin;


    View view;

    RecyclerView usdtcoinrecyler;
    RecyclerView.LayoutManager mLayoutManager;

    ResultAdapter usdtAdapter;
    MarketAdapter btcAdapter;
    MarketAdapter ethAdapter;


    Result usdt_response =new Result();
    Result btc_response =new Result();
    Result eth_response =new Result();



    ArrayList<Rv_object_coin> result_USDresponse =new ArrayList<Rv_object_coin>();
    ArrayList<Rv_object_coin> result_ETHresponse =new ArrayList<Rv_object_coin>();
    ArrayList<Rv_object_coin> result_BTCresponse =new ArrayList<Rv_object_coin>();

    ChildDataItem childDataItem;
    ArrayList<ChildDataItem> list;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        onClickETH =(LinearLayout) view.findViewById(R.id.topEthLay);
//        onClickUSDT =(LinearLayout) view.findViewById(R.id.topUsdtLay);
//        onClickBTC=(LinearLayout) view.findViewById(R.id.topBtcLay);








    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.usdt_coin_fragment,container,false);
        usdtcoinrecyler=(RecyclerView) view.findViewById(R.id.ucf_usdtcoinrecyler);


        list =new ArrayList<ChildDataItem>();
        int n;



        mLayoutManager=new LinearLayoutManager(getActivity());


        usdToCoin=ApiUtils.getAPIService();
        usdToCoin.getTop25().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                usdt_response =response.body();
                result_USDresponse = usdt_response.getResult();
                String y=result_USDresponse.size()+"";
                Log.i("dolar boyutu",y);
                usdtAdapter = new ResultAdapter(result_USDresponse,list);
                usdtcoinrecyler.setLayoutManager(mLayoutManager);
                usdtcoinrecyler.setItemAnimator(new DefaultItemAnimator());
                usdtcoinrecyler.setAdapter(usdtAdapter);


            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });








        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        onClickETH =(LinearLayout) view.findViewById(R.id.topEthLay);
        onClickUSDT =(LinearLayout) view.findViewById(R.id.topUsdtLay);
        onClickBTC=(LinearLayout) view.findViewById(R.id.topBtcLay);


        onClickUSDT.setBackgroundResource(R.color.topBarSelected);



        onClickBTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBTC.setBackgroundResource(R.color.topBarSelected);
                onClickUSDT.setBackgroundResource(R.color.toolbar_bg);
                onClickETH.setBackgroundResource(R.color.toolbar_bg);


                btcToCoin=ApiUtils.getAPIService();
                btcToCoin.getCoinWithType("BTC").enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        btc_response=response.body();
                        result_BTCresponse=btc_response.getResult();
                        btcAdapter=new MarketAdapter(result_BTCresponse);
                        usdtcoinrecyler.setLayoutManager(mLayoutManager);
                        usdtcoinrecyler.setItemAnimator(new DefaultItemAnimator());
                        usdtcoinrecyler.setAdapter(btcAdapter);
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {

                    }
                });
            }
        });


        onClickETH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickUSDT.setBackgroundResource(R.color.toolbar_bg);
                onClickBTC.setBackgroundResource(R.color.toolbar_bg);
                onClickETH.setBackgroundResource(R.color.topBarSelected);
                ethToCoin=ApiUtils.getAPIService();
                ethToCoin.getCoinWithType("ETH").enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        eth_response=response.body();
                        result_ETHresponse=eth_response.getResult();
                        ethAdapter=new MarketAdapter(result_ETHresponse);
                        usdtcoinrecyler.setLayoutManager(mLayoutManager);
                        usdtcoinrecyler.setItemAnimator(new DefaultItemAnimator());
                        usdtcoinrecyler.setAdapter(ethAdapter);


                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {

                    }
                });





            }
        });

       onClickUSDT.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("ResourceAsColor")
           @Override
           public void onClick(View v) {
               onClickUSDT.setBackgroundResource(R.color.topBarSelected);
               onClickETH.setBackgroundResource(R.color.toolbar_bg);
               onClickBTC.setBackgroundResource(R.color.toolbar_bg);
               btcToCoin=ApiUtils.getAPIService();
               btcToCoin.getCoinWithType("USDT").enqueue(new Callback<Result>() {
                   @Override
                   public void onResponse(Call<Result> call, Response<Result> response) {
                       usdt_response=response.body();
                       result_USDresponse=usdt_response.getResult();
                       usdtAdapter.setDataSet(result_USDresponse);
                       usdtcoinrecyler.setLayoutManager(mLayoutManager);
                       usdtcoinrecyler.setItemAnimator(new DefaultItemAnimator());
                       usdtcoinrecyler.setAdapter(usdtAdapter);


                   }

                   @Override
                   public void onFailure(Call<Result> call, Throwable t) {

                   }
               });

           }
       });



    }





}


