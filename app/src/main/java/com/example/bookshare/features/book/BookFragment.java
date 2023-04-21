package com.example.bookshare.features.book;

import android.annotation.SuppressLint;
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
import com.example.bookshare.features.book.helper.BookPojo;

public class BookFragment extends Fragment implements BookContract.View{

    View bookView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return bookView = inflater.inflate(R.layout.fragment_book, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstenceState) {
        super.onViewCreated(view, savedInstenceState);

        // create an object of the bookPresenter class and call the setBook method
        BookPresenter bookPresenter = new BookPresenter(this);
        bookPresenter.setBooks();
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
        RecyclerView recyclerView = bookView.findViewById(R.id.rvBook);
        BookAdapter thisAdapter = new BookAdapter(getActivity(), body.getBooks());
        recyclerView.setAdapter(thisAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        thisAdapter.notifyDataSetChanged();

        // add divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}