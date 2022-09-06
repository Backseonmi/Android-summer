package com.cookandroid.and0801_02_ativityone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn_New;
    EditText edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]첫번째 화면");
        btn_New = findViewById(R.id.btn_New);
        rg = findViewById(R.id.rg);
        edtContent = findViewById(R.id.edtContent);

        btn_New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtContent.getText().toString(); //넘겨줄 값 가져오기
                if(rg.getCheckedRadioButtonId()==R.id.rdo_Second){
                    Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                    in.putExtra("Content", str); //값 넘겨주기
                    startActivity(in); //SecondActivity화면에 열기
                }else{
                    Intent in = new Intent(getApplicationContext(), ThirdActivity.class);
                    in.putExtra("Content", str);
                    startActivity(in); //ThirdActivity화면에 열기
                }
            }
        });

    }
}