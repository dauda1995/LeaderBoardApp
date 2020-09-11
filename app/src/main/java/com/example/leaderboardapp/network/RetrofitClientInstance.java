package com.example.leaderboardapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by praka on 12/24/2017.
 */

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static Retrofit sRetrofit;
    private static final String BASE_URL_GET = "https://gadsapi.herokuapp.com";
    private static final String BASE_URL_POST = "https://docs.google.com/forms/d/e/";



    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {

                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL_GET)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


        }
        return retrofit;
    }

    public static Retrofit getRetSubmitInstance() {

        if (sRetrofit == null) {

                sRetrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL_POST)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
        return sRetrofit;
    }


}
