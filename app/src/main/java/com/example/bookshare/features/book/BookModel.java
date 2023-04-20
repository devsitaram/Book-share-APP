package com.example.bookshare.features.book;

import com.example.bookshare.features.api.ApiCallInstance;
import com.example.bookshare.features.api.ApiServices;
import com.example.bookshare.features.book.helper.BookPojo;

import retrofit2.Call;
import retrofit2.Retrofit;

public class BookModel implements BookContract.Model {

    @Override
    public Call<BookPojo> getBooks() {
        Retrofit retrofit = ApiCallInstance.getRetrofitInstance();
        return retrofit.create(ApiServices.class).getBooks();
    }
}
