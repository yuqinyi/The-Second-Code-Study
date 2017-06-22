package com.rdx64.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            String outData = savedInstanceState.getString("data_key");
            Log.d(TAG, "onCreate: " + outData);
        }
        Button sna = (Button) findViewById(R.id.start_normal_activity);
        Button sda = (Button) findViewById(R.id.start_dialog_activity);
        sna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ina = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(ina);
            }
        });
        sda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ida = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(ida);
            }
        });
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String outData = "Something you just typed";
        outState.putString("data_key", outData);
    }
}
