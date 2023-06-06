package com.sitaram.bookshare.features.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.io.IOException;
import java.util.Objects;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FirebaseInstanceNotificationService extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
    }

    public void notification() {
        FirebaseMessaging
            .getInstance()
            .getToken()
            .addOnCompleteListener(task -> {
                if (!task.isSuccessful()) {
                    Log.e("Error Message", Objects.requireNonNull(task.getException()).getLocalizedMessage());
                }
                // get new FCM registration token
                String token = task.getResult();
                getSendToServer(token);

                //  String message = getString(R.string.notification, token);
                Log.d("Token", token);
            });
    }

    public void getSendToServer(String token) {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("token", token)
                .build();
        Request request = new Request.Builder()
                .url("http://172.16.0.85")
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e("Server Request", "Failed to send token to server: " + e.getMessage());

            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                if (response.isSuccessful()) {
                    Log.d("Server Request", "Token sent successfully");
                    Log.d("Token", "onResponse:" + token);
                } else {
                    Log.e("Server Request", "Failed to send token to server: " + response.code());
                }
                response.close();
            }
        });
    }
}
