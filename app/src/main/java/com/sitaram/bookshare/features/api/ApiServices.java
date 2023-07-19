package com.sitaram.bookshare.features.api;

import com.sitaram.bookshare.features.product.helper.BookPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

// this is the interface where it can be used the multiple places
public interface ApiServices {

    // local server data
    @Headers({"X-RapidAPI-Key: ", "71bf5ec090msha9ecf2d7b476478p1f2533jsnd5cef4e5ef55",
            "X-RapidAPI-Host: ", "latest-stock-price.p.rapidapi.com"})
    @GET("")
    Call<BookPojo> getBooks();

    // API call to get the data where it cannot be get any parameter
//    @Headers({"X-RapidAPI-Key: 71bf5ec090msha9ecf2d7b476478p1f2533jsnd5cef4e5ef55",
//            "X-RapidAPI-Host: book4.p.rapidapi.com"})
//    @GET("/")
//    Call<BookPojo> getBooks();
}