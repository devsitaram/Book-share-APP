package com.sitaram.bookshare.features.home;

import androidx.annotation.NonNull;

public class HomePresenter implements HomeContract.Presenter {

    // innitialize he final variable
    private final HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }

    // check the google search text is empty or not
    @Override
    public void getGoogleSearch(@NonNull String searchText) {
        // check the fields is empty or not
        if (searchText.isEmpty()) {
            view.errorMessage("The fields is empty!");
        } else {
            view.googleSearch(searchText);
        }
    }
}
