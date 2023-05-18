package com.sitaram.bookshare.features.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCallInstance {
    private static Retrofit retrofit;

//    private static final String BASE_URL = "https://book4.p.rapidapi.com/"; // API base URL
//    private static final String BASE_URL = "http://100.64.235.184/sitaram/"; // college
    private static final String BASE_URL = "http://172.16.0.85/sitaram/"; // skill

    // create the instance of Retrofit
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            // create object of okHttpClient
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()) // converter
                    .build();
        }
        return retrofit;
    }
}
