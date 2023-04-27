package com.sitaram.bookshare.features.contact;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bookshare.R;
import com.google.android.material.textfield.TextInputEditText;
import com.sitaram.bookshare.features.home.HomeFragment;

import java.util.Objects;

public class ContactFragment extends Fragment {

    Button btnBackToHome, btnShowEmailLayout, btnShowContactLayout, btnSendMail, btnCall, btnSearch;
    TextInputEditText inputTextEmail, inputTextSubject, inputTextMessages, inputTextSearch, inputTextContactNum;
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
        btnBackToHome = cView.findViewById(R.id.btnBackToHome);
        btnSendMail = cView.findViewById(R.id.btnSendMail);
        btnCall = cView.findViewById(R.id.btnCall);
        btnSearch = cView.findViewById(R.id.btnGoogleSearch);

        // inputTextEditText fields initialize find view by id
        inputTextEmail = cView.findViewById(R.id.inputTextEmailAddress);
        inputTextSubject = cView.findViewById(R.id.inputTextEmailSubject);
        inputTextMessages = cView.findViewById(R.id.inputTextEmailMessages);
        inputTextSearch = cView.findViewById(R.id.inputTextSearchInfo);
        inputTextContactNum = cView.findViewById(R.id.inputTextPhoneNumber);

        // button setOnClickListener methods
        btnBackToHome.setOnClickListener(v -> navigateHome());
        btnShowEmailLayout.setOnClickListener(v -> emailLayoutVisible());
        btnShowContactLayout.setOnClickListener(v -> contactLayoutVisible());
        btnSendMail.setOnClickListener(v -> sendMail());
        btnCall.setOnClickListener(v -> call());
        btnSearch.setOnClickListener(v -> {
            String searchText = Objects.requireNonNull(inputTextSearch.getText()).toString();
            googleSearch(searchText);
        });
    }

    // navigate into home
    private void navigateHome(){
        // go to the home fragment class
        HomeFragment homeFragment = new HomeFragment();
        @SuppressLint("UseRequireInsteadOfGet")
        FragmentTransaction fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flMainContener, homeFragment).addToBackStack(null).commit();
    }

    // email layout visible
    @SuppressLint("UseCompatLoadingForDrawables")
    public void emailLayoutVisible() {
        btnShowContactLayout.setTextColor(getResources().getColor(R.color.redColor, null));
        btnShowEmailLayout.setBackground(getResources().getDrawable(R.drawable.switch_tricks, null));
        btnShowContactLayout.setBackground(null);
        contactPhoneLayout.setVisibility(View.GONE);
        contactEmailLayout.setVisibility(View.VISIBLE);
        btnShowEmailLayout.setTextColor(getResources().getColor(R.color.textColor, null));
    }

    // contact layout visible
    @SuppressLint("UseCompatLoadingForDrawables")
    public void contactLayoutVisible() {
        btnShowContactLayout.setBackground(getResources().getDrawable(R.drawable.switch_tricks, null));
        btnShowContactLayout.setTextColor(getResources().getColor(R.color.textColor, null));
        btnShowEmailLayout.setBackground(null);
        contactEmailLayout.setVisibility(View.GONE);
        contactPhoneLayout.setVisibility(View.VISIBLE);
        btnShowEmailLayout.setTextColor(getResources().getColor(R.color.redColor, null));
    }

    // email message send
    private void sendMail() {
        String listOfMail = Objects.requireNonNull(inputTextEmail.getText()).toString();
        String[] recipients = listOfMail.split(","); // one time send message for multiple email address

        // get the subject and message for text fields
        String subject = Objects.requireNonNull(inputTextSubject.getText()).toString();
        String message = Objects.requireNonNull(inputTextMessages.getText()).toString();

        // intent used to put details
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc8822");
        startActivity(Intent.createChooser(intent, "Choose your email?"));
    }

    // contact with another person
    private void call(){
        Intent call = new Intent(Intent.ACTION_DIAL);
        String contactNumber = Objects.requireNonNull(inputTextContactNum.getText()).toString();
        call.setData(Uri.parse("tel: "+contactNumber));
        startActivity(call);
        inputTextContactNum.setText("");
    }

    // google search
    private void googleSearch(String searchText){
        try{
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, searchText);
            startActivity(intent);
        }catch (Exception ex){
            ex.printStackTrace();
            googleSearch(searchText); // recall the methods
        }
    }
}