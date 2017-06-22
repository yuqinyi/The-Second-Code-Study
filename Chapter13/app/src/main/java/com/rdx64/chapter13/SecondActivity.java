package com.rdx64.chapter13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        PersonS personS = (PersonS) getIntent().getSerializableExtra("person_data");
        PersonP personP = getIntent().getParcelableExtra("person_data_p");
        LogUtil.d(TAG, "onCreate: " + personS.getName());
        LogUtil.d(TAG, "onCreate: " + personS.getAge());
        LogUtil.d(TAG, "onCreate: " + personP.getName());
        LogUtil.d(TAG, "onCreate: " + personP.getAge());
    }
}