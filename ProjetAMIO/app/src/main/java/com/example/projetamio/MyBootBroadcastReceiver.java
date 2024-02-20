package com.example.projetamio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.preference.CheckBoxPreference;

public class MyBootBroadcastReceiver extends BroadcastReceiver {
public MyBootBroadcastReceiver(){}
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Broadcast", "BOOT_COMPLETED recuuuuuuuuuuuuuuuuuuuuuu ");
    Toast.makeText(context, "Broadcast message received: ",
            Toast.LENGTH_SHORT).show();

        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

    }
}