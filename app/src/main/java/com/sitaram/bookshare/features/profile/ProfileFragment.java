package com.sitaram.bookshare.features.profile;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.bookshare.R;
import com.sitaram.bookshare.features.home.HomeFragment;
import com.sitaram.bookshare.features.setting.SettingActivity;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    RecyclerView pRecyclerView;
    List<CollectionPojo> collectionPojoList;
    Button btnBackToHome, btnGoSetting;
    private ImageView imageCapture;
    public static final int IMAGE_CODE = 1;
    Uri imageUri;
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
        HomeFragment homeFragment = new HomeFragment();

        btnBackToHome = pView.findViewById(R.id.btnProfileToHome);
        btnGoSetting = pView.findViewById(R.id.btnProfileToSetting);
        imageCapture = pView.findViewById(R.id.ivProfilePicture);

        setRecyclerView();// call this methods where set the recycler view

        btnBackToHome.setOnClickListener(v -> {
            // go to the home fragment class
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flMainContener, homeFragment).addToBackStack(null).commit();
        });

        btnGoSetting.setOnClickListener(v -> navigateSetting());
//        imageCapture.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                takeProfilePicture(); // caa this methods
//            }
//        });


//        imageCaptureLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
//            if (result.getResultCode() == Activity.RESULT_OK) {
//                // Handle the result here
//                Intent data = result.getData();
//                assert data != null;
//                Bitmap bitmap = (Bitmap) (data.getExtras().get("data"));
//                imageCapture.setImageBitmap(bitmap);
//            }
//        });

        imageCapture.setOnClickListener(v -> takePictureFromGallery());
    }

//    public void takeProfilePicture(){
//        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intentCamera,0);
//    }

    public void takePictureFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_CODE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            imageCapture.setImageURI(imageUri);
        } else {
            assert data != null;
            Bitmap bitmap = (Bitmap) (data.getExtras().get("data"));
            imageCapture.setImageBitmap(bitmap);
        }
    }

    // profile page to navigate setting page
    private void navigateSetting(){
        startActivity(new Intent(getActivity(), SettingActivity.class));
    }

    // set the collection image with recycler view
    public void setRecyclerView(){
        // call the arrayList and contracture
        collectionPojoList = new ArrayList<>();
        collectionPojoList.add(new CollectionPojo(R.mipmap.img_mynatures, "Natures", "31 photos"));
        collectionPojoList.add(new CollectionPojo(R.mipmap.img_myanimals, "Animals", "22 photos"));
        collectionPojoList.add(new CollectionPojo(R.mipmap.img_myfoods, "My Foods", "25 photos"));
        collectionPojoList.add(new CollectionPojo(R.mipmap.img_myarts, "My Arts", "7 photos"));
        collectionPojoList.add(new CollectionPojo(R.mipmap.img_mybook, "My Books", "12 photos"));
        // add the recycler view
        ProfileAdapter profileAdapter = new ProfileAdapter(getActivity(), collectionPojoList);
        pRecyclerView.setAdapter(profileAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        pRecyclerView.setLayoutManager(linearLayoutManager);
    }
}