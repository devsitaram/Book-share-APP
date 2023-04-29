package com.sitaram.bookshare.features.home;
import androidx.annotation.NonNull;

public class HomePresenter implements HomeContract.Presenter {
    private final HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }

    // check the google search text is empty or not
    @Override
    public void getGoogleSearch(@NonNull String searchText) {
        if (searchText.isEmpty()){
            view.errorMessage("The fields is empty!");
        } else {
            view.googleSearch(searchText);
        }
    }
}
