package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edt_ID, edt_PASSWORD;
    private Button btn_LOGIN, btn_Register;
    SQLiteDatabase sqlDB;
    MyDBHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_ID = findViewById(R.id.edt_ID);
        edt_PASSWORD = findViewById(R.id.edt_PASSWORD);
        btn_LOGIN = findViewById(R.id.btn_LOGIN);
        btn_Register = findViewById(R.id.btn_Register);
        myHelper = new MyDBHelper(this);
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });
        btn_LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = edt_ID.getText().toString().trim();
                String userPass = edt_PASSWORD.getText().toString().trim();
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT userID, userPass FROM user where userID = '" + userID + "' " + "and userPass = '" + userPass + "';", null);
                if (cursor.moveToFirst()) {
                    Intent in = new Intent(MainActivity.this, LoginOkActivity.class);
                    in.putExtra("userID", userID);
                    in.putExtra("userPass", userPass);
                    startActivity(in);
                } else {
                    Toast.makeText(getApplicationContext(), "로그인 실패(id, pw확인)", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
