package com.example.mobileappdevelop.json.ModelClassCurrentWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mobile App Develop on 4/17/2017.
 */

public class Clouds {
    @SerializedName("all")
    @Expose
    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }
}
