package com.sitaram.bookshare.features.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.util.Objects;

public class FirebaseInstanceNotificationService extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        // save toke to preference util

    }

    public void notification(){
        FirebaseMessaging
                .getInstance()
                .getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.e("Error Message", Objects.requireNonNull(task.getException()).getLocalizedMessage());
                        }
                        // get new FCM registration token
                        String token = task.getResult();
                        //  String message = getString(R.string.notification, token);
                        Log.d("Token", token);
                    }
                });
    }
}
