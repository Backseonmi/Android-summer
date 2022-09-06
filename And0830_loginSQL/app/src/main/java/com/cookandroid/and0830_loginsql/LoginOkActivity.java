package com.cookandroid.and0830_loginsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginOkActivity extends AppCompatActivity {
    private TextView txt_ID, txt_PASSWORD;
    private Button btn_end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ok);
        txt_ID = findViewById(R.id.txt_ID);
        txt_PASSWORD = findViewById(R.id.txt_PASSWORD);
        btn_end = findViewById(R.id.btn_end);
        Intent in = getIntent();
        String userID = in.getStringExtra("userID");
        String userPass = in.getStringExtra("userPass");
        txt_ID.setText(userID);
        txt_PASSWORD.setText(userPass);
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}