package com.example.ahmetserdargeze.koinplusapp.recylerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmetserdargeze.koinplusapp.R;
import com.example.ahmetserdargeze.koinplusapp.Rv_object_coin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmetserdargeze on 27.03.2018.
 */

public class ResultAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private ArrayList<Rv_object_coin> dataSet;

    public ResultAdapter(ArrayList<Rv_object_coin> dataArgs){
        this.dataSet=dataArgs;

    }

    public void setDataSet(ArrayList<Rv_object_coin> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coin_cardview,parent,false);


        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
//        final SimpleViewHolder holder1=holder;
        Rv_object_coin coin=dataSet.get(position);
        holder.setData(coin,position);
//        holder1.coin_name.setText(dataSet.get(position).getKoinIdKoinName()+"");
//        holder1.coin_price.setText(dataSet.get(position).getLast()+"");
//        holder1.change.setText(dataSet.get(position).getChange()+"");
//        holder1.volume.setText(dataSet.get(position).getVolume()+"");
//        holder1.kur.setText(dataSet.get(position).getKurIdKurName()+"");
//        holder1.baseVolume.setText(dataSet.get(position).getBaseVolume()+"");
//        holder1.time.setText(dataSet.get(position).getTime());
//        holder1.low.setText(dataSet.get(position).getLow());
//        holder1.coin_pic.setImageResource(R.drawable.btc_t);
//        holder1.alarm.setImageResource(R.drawable.if_alarm_408410);


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
