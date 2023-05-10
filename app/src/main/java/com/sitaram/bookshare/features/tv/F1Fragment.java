package com.sitaram.bookshare.features.tv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.bookshare.R;

public class F1Fragment extends Fragment {

    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_f1, container, false);
        // Assign variable
//        textView = view.findViewById(R.id.text_view);
//
//        // Get Title
//        assert getArguments() != null;
//        String sTitle=getArguments().getString("title");
//
//        // Set title on text view
//        textView.setText(sTitle);

        // return view
        return view;
    }
}