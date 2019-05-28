package com.example.alerts;

public class MyFirebaseMessagingService {
    @Override
    public  void onNewToken(String token) {
        Log.d(TAG, "Refreshed token:" + token);
        sendRegistrationToServer(token);
    }
}
