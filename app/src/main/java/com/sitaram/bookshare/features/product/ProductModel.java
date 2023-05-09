package com.sitaram.bookshare.features.product;

import com.sitaram.bookshare.features.api.ApiCallInstance;
import com.sitaram.bookshare.features.api.ApiServices;
import com.sitaram.bookshare.features.product.helper.BookPojo;

import retrofit2.Call;
import retrofit2.Retrofit;

public class ProductModel implements ProductContract.Model {

//    // book search by id
//    @Override
//    public Call<BookPojo> getSearchBook(String bookId) {
//        Retrofit retrofit = ApiCallInstance.getRetrofitInstance();
//        return retrofit.create(ApiServices.class).getSearchBook(bookId);
//    }

    // get all book details
    @Override
    public Call<BookPojo> getBooks() {
        Retrofit retrofit = ApiCallInstance.getRetrofitInstance();
        return retrofit.create(ApiServices.class).getBooks();
    }
}
