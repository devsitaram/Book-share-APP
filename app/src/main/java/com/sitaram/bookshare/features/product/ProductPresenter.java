package com.sitaram.bookshare.features.product;

import android.util.Log;

import androidx.annotation.NonNull;

import com.sitaram.bookshare.features.product.helper.BookPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductPresenter implements ProductContract.Presenter{

    private final ProductContract.View mView;
    private final ProductModel productModel = new ProductModel();
    public ProductPresenter(ProductContract.View mView) {
        this.mView = mView;
    }

    // to check the API call response
    @Override
    public void setBooks() {
        productModel.getBooks().enqueue(new Callback<BookPojo>() {
            @Override
            public void onResponse(@NonNull Call<BookPojo> call, @NonNull Response<BookPojo> response) {
                if (response.isSuccessful()) {
                    // set the response is setBook with response.body()
                    mView.setBooks(response.body());
                    mView.successMessage("Api call Success.");
                } else {
                    // show error message
                    mView.errorMessage("Api call BookPojo is unsuccessful.");
                }
            }

            // display the failed message
            @Override
            public void onFailure(@NonNull Call<BookPojo> call, @NonNull Throwable throwable) {
                throwable.printStackTrace();
                Log.d("onFailure", "Api call BookPojo is fails: " + throwable);
            }
        });
    }
}
