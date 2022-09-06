package com.cookandroid.and0801_04_ativityput2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    EditText edt_Name, edt_Num, edt_Home;
    RadioGroup rg;
    Button btnIn;
    String name, gender, tel, add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]첫번째 화면");
        edt_Name = findViewById(R.id.edt_Name);
        edt_Num = findViewById(R.id.edt_Num);
        edt_Home = findViewById(R.id.edt_Home);
        rg = findViewById(R.id.rg);
        btnIn = findViewById(R.id.btnIn);

//        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if (rg.getCheckedRadioButtonId()==R.id.rgMan)gender="남자";
//                else gender="여자";
//            }
//        });
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edt_Name.getText().toString();
                tel = edt_Num.getText().toString();
                add = edt_Home.getText().toString();
                if(rg.getCheckedRadioButtonId()==R.id.rgMan)gender="남자";
                else gender="여자";
                Person p = new Person(name, gender, tel, add); //객체 생성
                Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                in.putExtra("person", p); //객체로 데이터 전송
                startActivity(in);
            }
        });

    }
}