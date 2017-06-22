package com.rdx64.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private EditText edtAccount;
    private EditText edtPassword;
    private Button login;
    private CheckBox rememberPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        edtAccount = (EditText) findViewById(R.id.account);
        edtPassword = (EditText) findViewById(R.id.password);
        rememberPassword = (CheckBox) findViewById(R.id.remember_password);
        login = (Button) findViewById(R.id.login);
        boolean isRemember = preferences.getBoolean("remember_password", false);
        if (isRemember) {
            String account = preferences.getString("account", "");
            String password = preferences.getString("password", "");
            edtAccount.setText(account);
            edtPassword.setText(password);
            rememberPassword.setChecked(true);
        }
        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = edtAccount.getText().toString();
                String password = edtPassword.getText().toString();
                if ("admin".equals(account) && "123456".equals(password)) {
                    editor = preferences.edit();
                    if (rememberPassword.isChecked()) {
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "account or password is invalid.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

