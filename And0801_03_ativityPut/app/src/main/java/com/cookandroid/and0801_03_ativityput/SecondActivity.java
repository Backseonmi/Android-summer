package com.cookandroid.and0801_03_ativityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    Button btnSecond;
    TextView txtEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("두번째 화면입니다.");
        btnSecond = findViewById(R.id.btnSecond);
        txtEmpty = findViewById(R.id.txtEmpty);
///////////////////////////넘겨받은 데이터 받기/////////////////////////////
        Intent in = getIntent();
        String name = in.getStringExtra("name");
        int age = in.getIntExtra("age", 0);
        ArrayList<String> hobby = in.getStringArrayListExtra("hobby");
///////////////////////////txtEmpty로 넘기기/////////////////////////////
        txtEmpty.setText("이름 :" + name + "\n나이: " + age + "\n 취미: ");
        for (String h : hobby) {
            txtEmpty.setText(txtEmpty.getText().toString() + h + " ");
        }

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //닫는거(종료)
            }
        });

    }
}