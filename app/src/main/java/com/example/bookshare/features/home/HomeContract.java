package com.example.bookshare.features.home;

import com.example.bookshare.features.book.helper.BookPojo;

public interface HomeContract {
    interface View{
        void setBooks(BookPojo body);
    }
}
