package com.example.bookshare.features.book;

import com.example.bookshare.features.book.helper.BookPojo;

import retrofit2.Call;

public interface BookContract {

    interface View {
        void successMessage(String success);

        void errorMessage(String error);

        void setBooks(BookPojo body);

//        void setSearchBook(List<BookPojo> body);
    }

    interface Presenter {
        void setBooks();

//        void setSearchBooks(String query);
    }

    interface Model {
        Call<BookPojo> getBooks();

//        Call<List<BookPojo>> getSearchBooks(String query);
    }
}
