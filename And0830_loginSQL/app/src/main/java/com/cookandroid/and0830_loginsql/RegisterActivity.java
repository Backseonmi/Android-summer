package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edt_ID_reg, edt_PASSWORD_reg, edt_NAME_reg, edt_AGE_reg;
    Button btn_Register_reg;
    SQLiteDatabase sqlDB;
    MyDBHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edt_ID_reg = findViewById(R.id.edt_ID_reg);
        edt_PASSWORD_reg = findViewById(R.id.edt_PASSWORD_reg);
        edt_NAME_reg = findViewById(R.id.edt_NAME_reg);
        edt_AGE_reg = findViewById(R.id.edt_AGE_reg);
        btn_Register_reg = findViewById(R.id.btn_Register_reg);
        myHelper = new MyDBHelper(this);
        btn_Register_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = edt_ID_reg.getText().toString().trim();
                String userPass = edt_PASSWORD_reg.getText().toString().trim();
                String userName = edt_NAME_reg.getText().toString().trim();
                int userAge = Integer.parseInt(edt_AGE_reg.getText().toString().trim());
                try{ //DB에 insert 처리
                    if(!userID.isEmpty() && !userPass.isEmpty()){
                        sqlDB = myHelper.getWritableDatabase();
                        sqlDB.execSQL("INSERT INTO user(userID, userPass, userName, userAge) VALUES ( '"+ userID + "', "+ "'" + userPass + "', " + "'"+ userName + "', "+userAge + ");");
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "회원 등록 성공", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(in);
                    }
                    else Toast.makeText(getApplicationContext(), "id, password 필수입력", Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "입력 실패(아이디 중복)", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}