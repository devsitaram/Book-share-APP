package com.example.bookshare.features.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.bookshare.R;
import com.example.bookshare.features.book.BookAdapter;
import com.example.bookshare.features.book.BookContract;
import com.example.bookshare.features.book.helper.BookPojo;
import com.example.bookshare.features.book.helper.BooksItem;

import java.util.ArrayList;

public class HomeFragment extends Fragment{

    Button btnNotification;
    View hView;

    ArrayList<Books> arrBooksList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return hView = inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setBookRecyclerView(); // call this methods

        // initialization the variable
        btnNotification = hView.findViewById(R.id.btn_notification);

        // notification button
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNotificationMessage(); // call this methods
            }
        });
    }

    public void setBookRecyclerView() {
        RecyclerView hRecyclerView = hView.findViewById(R.id.rvHomeBookItem);

        arrBooksList = new ArrayList<>();
        arrBooksList.add(new Books(R.mipmap.book_app_logo,"Hello"));
        arrBooksList.add(new Books(R.mipmap.book_app_logo,"Hello"));
        arrBooksList.add(new Books(R.mipmap.book_app_logo,"Hello"));
        arrBooksList.add(new Books(R.mipmap.book_app_logo,"Hello"));

        HomeAdapter homeAdapter = new HomeAdapter(getActivity(),arrBooksList);
        hRecyclerView.setAdapter(homeAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        hRecyclerView.setLayoutManager(linearLayoutManager);

        // add divider
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(hRecyclerView.getContext(),linearLayoutManager.getOrientation());
//        hRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    // notification button
    private void setNotificationMessage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Notification");
        builder.setMessage("No new notifications");
        // press the yes the logout the app
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                toastMassage("Thank you");// call the toast message
            }
        });
        // press the No then cancel to logout the app
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    // create a toastMassage method which accept the String parameter
    public void toastMassage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}


//
//    public void setRecyclerView(){
//        recyclerView = hView.findViewById(R.id.rvHomeBookItem);
//        BooksItem booksItem = new BooksItem();
//        arrBookItemList = new ArrayList<>();
//
////        ArrayList<BooksItem> arrBookList = new ArrayList<>();
////        arrBookList.add(booksItem.getUrl());
////        arrBookList.add(booksItem.getTitle());
//
//
////        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
////        recyclerView.setLayoutManager(linearLayoutManager);
////        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), arrBookList);
////        recyclerView.setAdapter(homeAdapter);
//    }