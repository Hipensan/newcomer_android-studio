package com.example.alert;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService extends Service {
    public FirebaseMessagingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());


        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            if (true) {

                scheduleJob();
            } else {

                handleNow();
            }

        }

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

    }


    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        sendRegistrationToServer(token);
    }

}

