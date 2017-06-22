package com.rdx64.chapter13;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by RDX64 on 2017/6/18.
 */

public class LongRunningService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtil.d("abc", "abc" + SystemClock.elapsedRealtime());
            }
        }).start();

//        new Thread(() -> {
//        }).start();

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int anHour = 3600000;
        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
        Intent intentL = new Intent(this, LongRunningService.class);
        PendingIntent pi = PendingIntent.getService(this, 0, intent, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);

        return super.onStartCommand(intent, flags, startId);
    }
}
