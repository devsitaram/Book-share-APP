package com.sitaram.bookshare.features.product;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bookshare.R;
import com.sitaram.bookshare.features.product.helper.BookPojo;

public class ProductFragment extends Fragment implements ProductContract.View{

    RecyclerView pRecyclerView;
    Context context;
    View bookView;
    boolean isApiCall = true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return bookView = inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstenceState) {
        super.onViewCreated(view, savedInstenceState);
        // call the api only one time
        if(isApiCall){
            // create an object of the bookPresenter class and call the setBook method
            ProductPresenter productPresenter = new ProductPresenter(this);
            productPresenter.setBooks();
            isApiCall = false;
        }
    }

    // if the system can be valid perform then show the successMessage with toast message
    @SuppressLint("ShowToast")
    @Override
    public void successMessage(String success) {
        Toast.makeText(getActivity(), success, Toast.LENGTH_LONG);
    }

    // encase the system can be invalid perform then show the errorMessage with toast message
    @Override
    public void errorMessage(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
    }

    // this methods can be add the recycler view
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void setBooks(@NonNull BookPojo body) {
        pRecyclerView = bookView.findViewById(R.id.rvBook);
        ProductAdapter thisAdapter = new ProductAdapter(getActivity(), body.getBooks());
        pRecyclerView.setAdapter(thisAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        pRecyclerView.setLayoutManager(linearLayoutManager);
        thisAdapter.notifyDataSetChanged();

        // add divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(pRecyclerView.getContext(),linearLayoutManager.getOrientation());
        pRecyclerView.addItemDecoration(dividerItemDecoration);
    }
}