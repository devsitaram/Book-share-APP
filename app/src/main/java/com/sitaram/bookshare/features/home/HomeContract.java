package com.sitaram.bookshare.features.home;

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
