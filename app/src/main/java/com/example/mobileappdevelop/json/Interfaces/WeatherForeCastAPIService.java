package com.example.mobileappdevelop.json.Interfaces;

import com.example.mobileappdevelop.json.ModelClassForecast.WeatherForeCastMain;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by r3l0ad3d on 4/18/17.
 */

public interface WeatherForeCastAPIService {
    /*@GET("data/2.5/forecast?q=Dhaka&units=metric&appid=8e3a5f8c16948a8c2c36fe44e9bb23ff")
    Call<WeatherForeCastMain> getForeCastRespons();*/

    @POST()
    Call<WeatherForeCastMain> getForeCastRespons(@Url String url);
}
