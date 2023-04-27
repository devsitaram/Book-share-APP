package com.sitaram.bookshare.features.home;

import com.sitaram.bookshare.features.product.helper.BookPojo;

public interface HomeContract {
    interface View{
        void setBooks(BookPojo body);
    }
}
