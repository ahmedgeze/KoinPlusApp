package com.example.ahmetserdargeze.koinplusapp.recylerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ahmetserdargeze.koinplusapp.R;
import com.example.ahmetserdargeze.koinplusapp.models.ChildDataItem;
import com.example.ahmetserdargeze.koinplusapp.models.Rv_object_coin;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ColorTemplate;

/**
 * Created by ahmetserdargeze on 27.03.2018.
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private Context context;
    ImageView coin_pic,alarm;
    TextView coin_name,coin_price,volume,change,grafikvalue,kur,baseVolume,time,low;
    LinearLayout parent,child;
    BarChart chart;
    List<BarEntry> entries =new ArrayList<>();













    public SimpleViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();

        coin_pic=(ImageView) itemView.findViewById(R.id.coin_pic);
        alarm=(ImageView) itemView.findViewById(R.id.alarm);
        coin_name=(TextView) itemView.findViewById(R.id.coin_name);
        coin_price=(TextView) itemView.findViewById(R.id.coin_price);
        volume=(TextView) itemView.findViewById(R.id.volume);
        change=(TextView) itemView.findViewById(R.id.change);

        grafikvalue=(TextView) itemView.findViewById(R.id.grafik_value);
        chart=(BarChart) itemView.findViewById(R.id.chart);

        parent=(LinearLayout) itemView.findViewById(R.id.parentLL);
        child=(LinearLayout) itemView.findViewById(R.id.rv_child_items);




        for(int i=0;i<90;i++){
            chart.setPadding(0,20,0,20);
            chart.setBackground(ContextCompat.getDrawable(context,R.color.toolbar_bg));
            parent.setOnClickListener(this);




        }









    }
    public  void setDataa(Rv_object_coin clickedObject,int position){
        this.coin_name.setText(clickedObject.getKoinIdKoinName()+"");
        this.coin_price.setText(clickedObject.getLast()+"");
        this.change.setText(clickedObject.getChange()+"");
        this.volume.setText(clickedObject.getVolume()+"");
        this.coin_pic.setImageResource(R.drawable.btc_t);
        this.alarm.setImageResource(R.drawable.if_alarm_408410);
        this.child.setVisibility(View.GONE);

        entries.add(new BarEntry(0f,30f));
        entries.add(new BarEntry(1f,80f));
        entries.add(new BarEntry(2f,60f));
        entries.add(new BarEntry(3f,50f));

        BarDataSet set =new BarDataSet(entries,"BAR DATA SET");
        BarData data=new BarData(set);
        data.setBarWidth(0.9f);


        this.chart.setData(data);
        this.chart.setFitBars(true);
        this.chart.invalidate();





    }


    @Override
    public void onClick(View v) {
        Log.i("visibled","görünür oldu");

        if(v.getId()==R.id.parentLL){
            if(child.getVisibility()==View.VISIBLE){
                child.setVisibility(View.GONE);
                Log.i("visibled"," oldu");

            }
            else {
                child.setVisibility(View.VISIBLE);
                Log.i("visibled","görünür oldu");
            }

        }



    }
}


