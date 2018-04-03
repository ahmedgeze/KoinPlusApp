package com.example.ahmetserdargeze.koinplusapp.recylerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmetserdargeze.koinplusapp.R;
import com.example.ahmetserdargeze.koinplusapp.Rv_object_coin;

import java.util.ArrayList;

/**
 * Created by ahmetserdargeze on 03.04.2018.
 */

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MyViewHolder> {
    ArrayList<Rv_object_coin> mDataList;
    LayoutInflater inflater;

    public MarketAdapter(ArrayList<Rv_object_coin> data){
        this.mDataList=data;

    }

    @Override
    public MarketAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coin_cardview,parent,false);
        MyViewHolder holder=new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MarketAdapter.MyViewHolder holder, int position) {
        Rv_object_coin clickedObject=mDataList.get(position);
        holder.setData(clickedObject,position);

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView coin_pic,alarm;
        TextView coin_name,coin_price,volume,change,kur,baseVolume,time,low;


        public MyViewHolder(View itemView) {
            super(itemView);
            coin_pic=(ImageView) itemView.findViewById(R.id.coin_pic);
            alarm=(ImageView) itemView.findViewById(R.id.alarm);
            coin_name=(TextView) itemView.findViewById(R.id.coin_name);
            coin_price=(TextView) itemView.findViewById(R.id.coin_price);
            volume=(TextView) itemView.findViewById(R.id.volume);
            change=(TextView) itemView.findViewById(R.id.change);

        }

        public  void setData(Rv_object_coin clickedObject,int position){
            this.coin_name.setText(clickedObject.getKoinIdKoinName()+"");
            this.coin_price.setText(clickedObject.getLast()+"");
            this.change.setText(clickedObject.getChange()+"");
            this.volume.setText(clickedObject.getVolume()+"");
            this.coin_pic.setImageResource(R.drawable.btc_t);
            this.alarm.setImageResource(R.drawable.if_alarm_408410);



        }

    }
}
