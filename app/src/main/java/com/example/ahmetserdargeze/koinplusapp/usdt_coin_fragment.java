package com.example.ahmetserdargeze.koinplusapp;

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
import android.widget.LinearLayout;

import com.example.ahmetserdargeze.koinplusapp.recylerview.MarketAdapter;
import com.example.ahmetserdargeze.koinplusapp.recylerview.ResultAdapter;
import com.example.ahmetserdargeze.koinplusapp.retrofit.APIService;
import com.example.ahmetserdargeze.koinplusapp.retrofit.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ahmetserdargeze on 10.03.2018.
 */

public class usdt_coin_fragment extends Fragment {
    LinearLayout onClickBTC;


    public APIService usdToCoin;


    View view;
    RecyclerView usdtcoinrecyler;
    RecyclerView.LayoutManager mLayoutManager;
    ResultAdapter rAdapter;
    MarketAdapter mAdapter;


    Result body_response=new Result();
    ArrayList<Rv_object_coin> result_response=new ArrayList<Rv_object_coin>();
    List<Rv_object_coin> result_response_two=new ArrayList<Rv_object_coin>();
    Rv_object_coin object_coin;














    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



//        dataset_res=new Rv_object_coin("sad","asd0","sadasd0","asdasd","sadasd","asdasd","asdsad","asd","asd");
//        on_createResponse= new Result(Boolean.TRUE,on_createResult);
//        result.add(dataset_res);




//        usdToCoin=ApiUtils.getAPIService();
//        usdToCoin.getTop25().enqueue(new Callback<Result>() {
//            @Override
//            public void onResponse(Call<Result> call, Response<Result> response) {
//                body_response.setMessages(response.body().getMessages());
////                result_response=body_response.getResult();
//                body_response.setResult(response.body().getResult());
//                for (int i=0;i<response.body().getResult().size();i++){
//                    result_response.add(body_response.getResult().get(i));
//                }
//
//                System.out.println("RESPONSE GÖNDERİLDİ"+" "+response.body().getResult());
//
//            }
//
//            @Override
//            public void onFailure(Call<Result> call, Throwable t) {
//                System.out.println("Bir hata ile karşılaşıldı");
//            }
//        });

//        usdToCoin=ApiUtils.getAPIService();
//        usdToCoin.getTop25().enqueue(new Callback<Result>() {
//            @Override
//            public void onResponse(Call<Result> call, Response<Result> response) {
//                body_response=response.body();
////                for (int i=0;i<body_response.getResult().size();i++){
////                    object_coin=new Rv_object_coin(body_response.getResult().get(i).getHigh()
////                            ,body_response.getResult().get(i).getLast()
////                            ,body_response.getResult().get(i).getTime(),
////                            body_response.getResult().get(i).getBaseVolume(),
////                            body_response.getResult().get(i).getKurIdKurName(),
////                            body_response.getResult().get(i).getLow(),
////                            body_response.getResult().get(i).getKoinIdKoinName(),
////                            body_response.getResult().get(i).getChange(),
////                            body_response.getResult().get(i).getVolume());
////                    result_response.add(object_coin);
////
////                }
//                result_response=body_response.getResult();
//
//            }
//
//            @Override
//            public void onFailure(Call<Result> call, Throwable t) {
//
//            }
//        });

//        object_coin=new Rv_object_coin("sad","sad","sad","sad","sad","sad","asd","sad","a");
//
//        result_response.add(object_coin);






    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i("oncreatView2" ,result_response.toString());

        view=inflater.inflate(R.layout.usdt_coin_fragment,container,false);
        usdtcoinrecyler=(RecyclerView) view.findViewById(R.id.ucf_usdtcoinrecyler);

        mLayoutManager=new LinearLayoutManager(getActivity());


        usdToCoin=ApiUtils.getAPIService();
        usdToCoin.getTop25().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                body_response=response.body();
                result_response=body_response.getResult();
                mAdapter=new MarketAdapter(result_response);
                rAdapter= new ResultAdapter(result_response);
                usdtcoinrecyler.setLayoutManager(mLayoutManager);
                usdtcoinrecyler.setItemAnimator(new DefaultItemAnimator());
                usdtcoinrecyler.setAdapter(rAdapter);


            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });






        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        Log.i("oncreatView" ,result_response.toString());
//
//        usdtcoinrecyler=(RecyclerView) view.findViewById(R.id.ucf_usdtcoinrecyler);
//
//        rAdapter=new ResultAdapter(result_response);
//        mLayoutManager=new LinearLayoutManager(getActivity());
//
//
//
//        usdtcoinrecyler.setLayoutManager(mLayoutManager);
//        usdtcoinrecyler.setItemAnimator(new DefaultItemAnimator());
//        usdtcoinrecyler.setAdapter(rAdapter);
//
//
//
//        onClickBTC=(LinearLayout) view.findViewById(R.id.topBtcLay);
//        onClickBTC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                usdtcoinrecyler.setLayoutManager(mLayoutManager);
//                usdtcoinrecyler.setItemAnimator(new DefaultItemAnimator());
//                usdtcoinrecyler.setAdapter(rAdapter);
//
//
//                usdToCoin= ApiUtils.getAPIService();
//


        //burdan sonrası yok

//                usdToCoin.getTop25().enqueue(new Callback<Result>() {
//                    @Override
//                    public void onResponse(Call<Result> call, Response<Result> response) {
//                        body_response=response.body();
//                        result_response=body_response.getResult();
//                        Log.i("RESULT",result_response.get(6).getKoinIdKoinName());
//                        usdtcoinrecyler.setLayoutManager(mLayoutManager);
//                        usdtcoinrecyler.setItemAnimator(new DefaultItemAnimator());
//                        usdtcoinrecyler.setAdapter(rAdapter);
//                    }
//
//                    @Override
//                    public void onFailure(Call<Result> call, Throwable t) {
//                        Log.i("RESULT","hata bulundu");
//                    }
//                });


//
//            }
//        });
//
//
//    }
    }


    //    private void initDataset(){
//        for (int i=0;i<55;i++){
//            nesne=new Rv_object_coin("ASDDS","12312,24.044455", "23.05","ASDDASS");
////            nesne.setCoin_name(i+"th coin");
////            nesne.setCoin_change(i*15.0);
////            nesne.setCoin_price(i*25);
////            nesne.setCoin_volume(new BigDecimal(15003424.4688));
//            dataSet.add(nesne);
//
//        }
//
//    }
}
