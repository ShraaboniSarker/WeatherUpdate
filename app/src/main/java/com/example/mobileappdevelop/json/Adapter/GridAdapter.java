package com.example.mobileappdevelop.json.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileappdevelop.json.DataModel.ForeCastReport;
import com.example.mobileappdevelop.json.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shraaboni on 4/22/2017.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyHolder> {

    private Context context;
    private List<ForeCastReport> reportList = new ArrayList<>();
    private String dataType;


    public GridAdapter(Context context, List<ForeCastReport> list,String dataType) {
        this.context = context;
        this.reportList = list;
        this.dataType = dataType;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,null);
        MyHolder holder= new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {


        if (dataType.equals("metric")) {
            holder.Tempereture.setText(reportList.get(position).getTemperature()+"° C");
        }else {
            holder.Tempereture.setText(reportList.get(position).getTemperature()+" F");
        }

        holder.Pressure.setText(reportList.get(position).getPressure()+" hPa");
        holder.Humidity.setText(reportList.get(position).getHumidity()+" %");
        holder.Cloud.setText(reportList.get(position).getClouds()+" %");
        holder.Date.setText(reportList.get(position).getDate());
        holder.WeatherReport.setText(reportList.get(position).getWeatherRepor());

        Picasso.with(context).load("http://openweathermap.org/img/w/"+
                reportList.get(position).getWeatherReporIcon()+".png")
                .into(holder.WeatherIcon);
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        ImageView WeatherIcon;
        TextView WeatherReport;
        TextView Date;
        TextView Tempereture;
        TextView Cloud;
        TextView Humidity;
        TextView Pressure;

        public MyHolder(View itemView) {

            super(itemView);
            WeatherIcon = (ImageView) itemView.findViewById(R.id.ivWeatherIconForeCast);
            WeatherReport = (TextView) itemView.findViewById(R.id.tvWeatherReportForeCast);
            Date = (TextView) itemView.findViewById(R.id.tvDateForeCast);
            Tempereture = (TextView) itemView.findViewById(R.id.tvTemperatureForeCast);
            Cloud = (TextView) itemView.findViewById(R.id.tvCloudForCast);
            Humidity = (TextView) itemView.findViewById(R.id.tvHumidityForCast);
            Pressure = (TextView) itemView.findViewById(R.id.tvPressureForCast);

        }
    }
}