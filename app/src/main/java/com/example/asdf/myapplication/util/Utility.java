package com.example.asdf.myapplication.util;

import android.text.TextUtils;
import android.util.Log;

import com.example.asdf.myapplication.db.City;
import com.example.asdf.myapplication.db.Country;
import com.example.asdf.myapplication.db.Province;
import com.example.asdf.myapplication.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by asdf on 2017/10/19.
 */

public class Utility {

    public static Weather handleWeatherResponse(String response) {

            try {
                JSONObject jsonObject= new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
                String weatherContent = jsonArray.getJSONObject(0).toString();
                return new Gson().fromJson(weatherContent,Weather.class);

            }catch (JSONException e) {
                e.printStackTrace();
            }

             return null;
    }

    public static boolean handleProvinceResponse(String response) {
        if(!TextUtils.isEmpty(response)) {
            try {
                Log.e("handleCityResponse-->",response);
                JSONArray allProvince= new JSONArray(response);
                for (int i=0;i<allProvince.length();i++) {
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e) {
                e.printStackTrace();

            }
        }
        return false;
    }

    public static boolean handleCityResponse(String response,int provinceId) {
        if(!TextUtils.isEmpty(response)) {
            try {
                Log.e("handleCityResponse-->",response);
                JSONArray allCities= new JSONArray(response);
                for (int i=0;i<allCities.length();i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e) {
                e.printStackTrace();

            }
        }
        return false;
    }

    public static boolean handleCountryResponse(String response,int cityId) {
        if(!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCountries= new JSONArray(response);
                for (int i=0;i<allCountries.length();i++) {
                    JSONObject countryObject = allCountries.getJSONObject(i);
                    Country country = new Country();
                    country.setCountryName(countryObject.getString("name"));
                    country.setWeatherId(countryObject.getString("weather_id"));
                    country.setCityId(cityId);
                    country.save();
                }
                return true;
            }catch (JSONException e) {
                e.printStackTrace();

            }
        }
        return false;
    }
}
