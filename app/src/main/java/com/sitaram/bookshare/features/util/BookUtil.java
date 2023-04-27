package com.sitaram.bookshare.features.util;

import android.util.Log;

import com.sitaram.bookshare.features.product.helper.BookPojo;

import java.util.ArrayList;

public class BookUtil {
    BookPojo bookPojo;
    ArrayList<BookUtil> bookUtilArrayList;
    public BookUtil(BookPojo bookPojo){
        this.bookPojo = bookPojo;
    }

    public void ApiDataStore(BookUtil bookUtil){
        bookUtilArrayList = new ArrayList<>();
        bookUtilArrayList.add(bookUtil);

        for (BookUtil array: bookUtilArrayList){
            Log.d("Data: ", array.toString());
        }
    }
}
