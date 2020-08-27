package com.bicubic.amusementpark.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    //    public static final String BASE_URL = "http://api.themoviedb.org/3/";
//    public static final String BASE_URL = "http://api.stackexchange.com/2.1/";
    public static final String BASE_URL = "http://192.168.1.201/eldorado/index.php/api/";
    public static final String BASE_URL_1 = "http://api.androidhive.info/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

}
