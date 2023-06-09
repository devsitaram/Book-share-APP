package com.sitaram.bookshare.features.product;

import com.sitaram.bookshare.features.product.helper.BookPojo;

import retrofit2.Call;

public interface ProductContract {

    // interface View
    interface View {
        void successMessage(String success);

        void errorMessage(String error);

        void setBooks(BookPojo body);

    }

    // interface Presenter
    interface Presenter {
        void setBooks();
//        void setSearchBooks(String query);
    }

    // interface Model
    interface Model {
        Call<BookPojo> getBooks();

//        Call<BookPojo> getSearchBook(String query);
    }
}
