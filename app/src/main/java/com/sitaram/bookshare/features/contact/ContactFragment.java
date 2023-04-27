package com.sitaram.bookshare.features.contact;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bookshare.R;

public class ContactFragment extends Fragment {

    Button btnShowEmailLayout, btnShowContactLayout, btnSendMail, btnCall, btnSearch;
    View cView, contactEmailLayout, contactPhoneLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return cView = inflater.inflate(R.layout.fragment_contract, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // button initialize
        btnShowEmailLayout = cView.findViewById(R.id.btnEmailLayout);
        btnShowContactLayout = cView.findViewById(R.id.btnContactLayout);
        // view initialize logInLayout
        contactEmailLayout = cView.findViewById(R.id.contactEmailLayout);
        contactPhoneLayout = cView.findViewById(R.id.contactPhoneLayout);
        // button
        btnSendMail = cView.findViewById(R.id.btnSendMail);
        btnCall = cView.findViewById(R.id.btnCall);
        btnSearch = cView.findViewById(R.id.btnGoogleSearch);

        // visible for the content
        btnShowEmailLayout.setOnClickListener(v -> emailLayoutVisible());
        btnShowContactLayout.setOnClickListener(v -> contactLayoutVisible());
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    public void emailLayoutVisible(){
        btnShowContactLayout.setTextColor(getResources().getColor(R.color.redColor, null));
        btnShowEmailLayout.setBackground(getResources().getDrawable(R.drawable.switch_tricks, null));
        btnShowContactLayout.setBackground(null);
        contactPhoneLayout.setVisibility(View.GONE);
        contactEmailLayout.setVisibility(View.VISIBLE);
        btnShowEmailLayout.setTextColor(getResources().getColor(R.color.textColor, null));
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    public void contactLayoutVisible(){
        btnShowContactLayout.setBackground(getResources().getDrawable(R.drawable.switch_tricks, null));
        btnShowContactLayout.setTextColor(getResources().getColor(R.color.textColor, null));
        btnShowEmailLayout.setBackground(null);
        contactEmailLayout.setVisibility(View.GONE);
        contactPhoneLayout.setVisibility(View.VISIBLE);
        btnShowEmailLayout.setTextColor(getResources().getColor(R.color.redColor, null));
    }

    // email send the message
//    private void sendMail(){
//        String recipients_list =  txtEmail.getText().toString();
//        String [] recipients = recipients_list.split( ","); // one time send message for multiple email address
//
//        // get the subject and message for text fields
//        String subject = txtSubject.getText().toString();
//        String message = txtDescription.getText().toString();
//
//        // intent used to put details
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//        intent.putExtra(Intent.EXTRA_TEXT, message);
//
//        intent.setType("message/rfc8822");
//        startActivity(Intent.createChooser(intent, "Choose your email?"));
//    }
}