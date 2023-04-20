package com.example.bookshare.features.api;

import com.example.bookshare.features.book.helper.BookPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

// this is the interface where it can be used the multiple places
public interface ApiServices {

    // add the header and create the getBook methods where it can be provide the list of books
    @Headers({"X-RapidAPI-Key: 71bf5ec090msha9ecf2d7b476478p1f2533jsnd5cef4e5ef55",
	        "X-RapidAPI-Host: book4.p.rapidapi.com"})
    @GET("book.json")
    Call<BookPojo> getBooks();
}

















//    @Headers({"X-RapidAPI-Key: 71bf5ec090msha9ecf2d7b476478p1f2533jsnd5cef4e5ef55",
//            "X-RapidAPI-Host: book4.p.rapidapi.com"})
//    @GET("/")
//    Call<BookPojo> getBooks();