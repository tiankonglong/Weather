package com.example.asdf.myapplication.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asdf on 2017/10/20.
 */

public class Now {
    @SerializedName("tmp")
    public  String temperature;

    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
