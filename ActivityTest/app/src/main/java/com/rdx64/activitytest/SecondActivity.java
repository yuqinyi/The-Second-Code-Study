package com.rdx64.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is: " + getTaskId());
        setContentView(R.layout.second_layout);
        final Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d(TAG, "onCreate: " + data);
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent1 = new Intent();
//                intent1.putExtra("data_return", "Hello FirstActivity");
//                setResult(RESULT_OK, intent1);
//                finish();
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent();
        intent1.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent1);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public static void startAction(Context context, String arg1, String arg2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("arg1", arg1);
        intent.putExtra("arg2", arg2);
        context.startActivity(intent);
    }
}
