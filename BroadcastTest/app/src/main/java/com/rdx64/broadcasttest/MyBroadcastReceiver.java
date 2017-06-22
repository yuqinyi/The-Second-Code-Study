package com.rdx64.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Receiver in MyBroadcastReceiver.", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
