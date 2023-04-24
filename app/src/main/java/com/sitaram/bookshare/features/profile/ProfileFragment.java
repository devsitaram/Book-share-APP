package com.sitaram.bookshare.features.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookshare.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    RecyclerView pRecyclerView;
    List<CollectionPojo> collectionPojoList;
    View pView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return pView = inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pRecyclerView = pView.findViewById(R.id.rvProfileCollection);

        collectionPojoList = new ArrayList<>();
        collectionPojoList.add(new CollectionPojo(R.mipmap.img_mynatures,"Natures", "31 photos"));
        collectionPojoList.add(new CollectionPojo(R.mipmap.img_myanimals,"Animals", "22 photos"));
        collectionPojoList.add(new CollectionPojo(R.mipmap.img_myarts,"My Arts", "7 photos"));
        collectionPojoList.add(new CollectionPojo(R.mipmap.img_mybook,"My Books", "12 photos"));
        collectionPojoList.add(new CollectionPojo(R.mipmap.img_myfoods,"My Foods", "25 photos"));

        ProfileAdapter profileAdapter  = new ProfileAdapter(getActivity(),collectionPojoList);
        pRecyclerView.setAdapter(profileAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        pRecyclerView.setLayoutManager(linearLayoutManager);
    }
}