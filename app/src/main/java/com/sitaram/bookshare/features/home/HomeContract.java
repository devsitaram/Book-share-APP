package com.sitaram.bookshare.features.home;

import android.content.Intent;

import com.sitaram.bookshare.features.product.helper.BookPojo;

public interface HomeContract {
    interface View {
        void successMessage(String success);
        void errorMessage(String error);
        void googleSearch(String searchText);
    }
    interface Presenter {
        void getGoogleSearch(String search);
    }
}
