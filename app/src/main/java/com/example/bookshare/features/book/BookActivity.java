package com.example.bookshare.features.book;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookshare.R;
import com.example.bookshare.features.book.helper.BookPojo;

public class BookActivity extends AppCompatActivity implements BookContract.View {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        // create an object of the bookPresenter class and call the setBook method
        BookPresenter bookPresenter = new BookPresenter(this);
        bookPresenter.setBooks();

    }

    // if the system can be valid perform then show the successMessage with toast message
    @SuppressLint("ShowToast")
    @Override
    public void successMessage(String success) {
        Toast.makeText(this, success, Toast.LENGTH_LONG);
    }

    // encase the system can be invalid perform then show the errorMessage with toast message
    @Override
    public void errorMessage(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    // this methods can be add the recycler view
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void setBooks(@NonNull BookPojo body) {
        RecyclerView recyclerView = findViewById(R.id.rvBook);
        BookAdapter thisAdapter = new BookAdapter(BookActivity.this, body.getBooks());
        recyclerView.setAdapter(thisAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BookActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        thisAdapter.notifyDataSetChanged();

        // add divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}