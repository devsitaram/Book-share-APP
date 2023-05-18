package com.sitaram.bookshare.features.home;

public interface HomeContract {

    // create the view interface
    interface View {
        void successMessage(String success);

        void errorMessage(String error);

        void googleSearch(String searchText);
    }

    // create the view Presenter
    interface Presenter {
        void getGoogleSearch(String search);
    }
}
