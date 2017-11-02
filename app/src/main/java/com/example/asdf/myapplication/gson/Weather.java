package com.example.asdf.myapplication.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asdf on 2017/10/20.
 */

public class Weather {
    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
