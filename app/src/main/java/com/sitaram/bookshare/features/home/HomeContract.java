package com.sitaram.bookshare.features.home;

import com.sitaram.bookshare.features.book.helper.BookPojo;

public interface HomeContract {
    interface View{
        void setBooks(BookPojo body);
    }
}
