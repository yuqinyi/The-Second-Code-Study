package com.rdx64.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is: " + getTaskId());
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this, "You clicked Button 1.", Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                Intent intent = new Intent("com.rdx64.activitytest.ACTION_START_SECOND");
//                intent.addCategory("com.rdx64.activitytest.MY_CATEGORY_SECOND");
//                intent.putExtra("extra_data", "Hello SecondActivity");
//                startActivityForResult(intent, 1);

                SecondActivity.startAction(FirstActivity.this, "arg1data", "arg2data");
            }
        });
        Button button2 = (Button) findViewById(R.id.button_1_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                intent.setData(Uri.parse("http://mimamori2p1.azurewebsites.net/mgmt/zwgetcompanyinfo.php"));
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.additem:
                Toast.makeText(FirstActivity.this, "You selected Add.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.removeitem:
                Toast.makeText(FirstActivity.this, "You selected Remove.", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String rData = data.getStringExtra("data_return");
                    Log.d(TAG, "onActivityResult: " + rData);
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
