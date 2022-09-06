package com.cookandroid.and0801_04_ativityput2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtContent;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("[백선미]첫번째 화면");
        txtContent = findViewById(R.id.txtContent);
        btnReturn = findViewById(R.id.btnReturn);
//////////////////////////////////////////////////////
        Intent in = getIntent();
        Person p = (Person) in.getSerializableExtra("person");
        String str = "이름: " + p.getName() + "\n성별: " + p.getGender() + "\n전화: " + p.getTel() + "\n주소: " + p.getAdd();
        txtContent.setText(str);
/////////////////////////////////////////////////////////////////
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}