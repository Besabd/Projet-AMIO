package com.example.projetamio;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MainService extends Service {
    TimerTask task;
    Timer timer = new Timer("Timer");
    public MainService() {
    }
    public void onCreate() {
        // Création du service
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.d("MainService_start", "MainService: ");
        task = new  TimerTask() {
            public void run() {
                Log.d("MainService_start", "period ");
            }};
        timer.schedule(task, 0, 5000);

        return START_STICKY;
    }

    public void onDestroy() {
        // Destruction du service
        timer.cancel();
    }
}