package com.example.mobileappdevelop.json.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobileappdevelop.json.Adapter.GridAdapter;
import com.example.mobileappdevelop.json.DataModel.ForeCastReport;
import com.example.mobileappdevelop.json.Interfaces.WeatherForeCastAPIService;
import com.example.mobileappdevelop.json.MainActivity;
import com.example.mobileappdevelop.json.MenuService;
import com.example.mobileappdevelop.json.ModelClassForecast.WeatherForeCastMain;
import com.example.mobileappdevelop.json.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentForeCase extends Fragment {

    private static final String BASE_URL = "http://api.openweathermap.org/";

    private MenuService menuService;
    private static String CITY="Dhaka";
    private static String COUNTRY="Bangladesh";
    private static String TYPE="metric";

    private RecyclerView mRecyclerView;
    private TextView tvTest;

    private GridLayoutManager gridLayoutManager;
    private GridAdapter gridAdapter;
    private List<ForeCastReport> reportList;

    public FragmentForeCase() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        menuService = new MainActivity();
        CITY = menuService.getCity();
        COUNTRY = menuService.getCounty();
        TYPE = menuService.getType();

        View view= inflater.inflate(R.layout.fragment_fragment_fore_case, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        tvTest = (TextView) view.findViewById(R.id.tvTest);

        reportList = new ArrayList<>();
        gridAdapter = new GridAdapter(getContext(),reportList,TYPE);
        gridLayoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(gridAdapter);

        getRespons();

        return view;
    }

    private void getRespons(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherForeCastAPIService apiService = retrofit.create(WeatherForeCastAPIService.class);
        Call<WeatherForeCastMain> foreCastMainCall = apiService.getForeCastRespons("data/2.5/forecast?q="+CITY+"&units="+TYPE+"&appid=8e3a5f8c16948a8c2c36fe44e9bb23ff");

        foreCastMainCall.enqueue(new Callback<WeatherForeCastMain>() {
            @Override
            public void onResponse(Call<WeatherForeCastMain> call, Response<WeatherForeCastMain> response) {
                if(response.code()==200){
                    WeatherForeCastMain data = response.body();
                    setData(data);
                }else{
                    tvTest.setText("Nothing Get From Respons");
                }
            }

            @Override
            public void onFailure(Call<WeatherForeCastMain> call, Throwable t) {
                tvTest.setText(t.getMessage());
            }
        });
    }

    private void setData(WeatherForeCastMain data) {
        ForeCastReport foreCastReport = new ForeCastReport(data);
        List<ForeCastReport> list = new ArrayList<>();
        list.addAll(foreCastReport.getReportList());
        tvTest.setText(list.get(0).getDate());
        reportList.addAll(list);
        gridAdapter.notifyDataSetChanged();
        //tvTest.setText(String.valueOf(data.getList().get(0).getMain().getTemp()));
    }

}
