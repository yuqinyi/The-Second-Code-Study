package com.rdx64.chapter13;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                PersonS personS = new PersonS();
                personS.setName("YoY");
                personS.setAge(37 ^ new Random().nextInt(255));
                intent.putExtra("person_data", personS);

                PersonP personP = new PersonP();
                personP.setName("YYo");
                personP.setAge(27 ^ new Random().nextInt(255));
                intent.putExtra("person_data_p", personP);
                startActivity(intent);
            }
        });
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long triggerAtTime = SystemClock.elapsedRealtime() + 10000;
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, null);
        doSomeThing();
    }

    private String doSomeThing(MyListener listener) {
        String a = "Hello lambda";
        int b = 2017;
        return listener.doSomething(a, b);
    }

    private void doSomeThing() {
        String aaaa = doSomeThing((a, b) -> {
            return a + b;
        });
        LogUtil.d("a", aaaa);
    }
}
