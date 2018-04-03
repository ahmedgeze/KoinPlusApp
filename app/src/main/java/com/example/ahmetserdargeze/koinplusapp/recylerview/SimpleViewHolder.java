package com.example.ahmetserdargeze.koinplusapp.recylerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmetserdargeze.koinplusapp.R;
import com.example.ahmetserdargeze.koinplusapp.Rv_object_coin;

/**
 * Created by ahmetserdargeze on 27.03.2018.
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    ImageView coin_pic,alarm;
    TextView coin_name,coin_price,volume,change,kur,baseVolume,time,low;


    public SimpleViewHolder(View itemView) {
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
