package com.kardusinfo.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private PrefManager prefManager;
    private EditText edtName, edtEmail, edtPassword;
    private Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        prefManager = new PrefManager(this, "MANTAB");
        edtName = findViewById(R.id.editName);
        edtEmail = findViewById(R.id.editEmail);
        edtPassword = findViewById(R.id.editPassword);
        btnSignUp = findViewById(R.id.buttonSignUp);
        if(prefManager.isSignedIn()){
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                if(name.isEmpty()||email.isEmpty()||password.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Lengkapi data anda", Toast.LENGTH_SHORT).show();
                }else{
                    prefManager.setPrefValue("NAME", name.trim());
                    prefManager.setPrefValue("EMAIL", email.trim());
                    prefManager.setPrefValue("PASSWORD", password.trim());
                    prefManager.setSignedStatus(true);
                    Toast.makeText(SignUpActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}