package com.kardusinfo.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private PrefManager prefManager;
    private TextView tvName, tvEmail;
    private Button btnSignOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefManager = new PrefManager(this,"MANTAB");
        tvName = findViewById(R.id.textName);
        tvEmail = findViewById(R.id.textEmail);
        btnSignOut = findViewById(R.id.buttonSignOut);
        tvName.setText(prefManager.getPrefValue("NAME"));
        tvEmail.setText(prefManager.getPrefValue("EMAIL"));
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefManager.removePref("MANTAB");
                prefManager.setSignedStatus(false);
                Log.d("PREF", "NAMA : " + prefManager.getPrefValue("NAME"));
                Log.d("PREF", "EMAIL : " + prefManager.getPrefValue("EMAIL"));
                Log.d("PREF", "PASSWORD : " + prefManager.getPrefValue("PASSWORD"));
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}