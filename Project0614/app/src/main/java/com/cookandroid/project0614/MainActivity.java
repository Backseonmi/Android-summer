package com.cookandroid.project0614;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton btnSecond, btnThird;
    Button btnOK, btnCancle, btn;
    String grade;
    CheckBox chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("백선미");
        rg = findViewById(R.id.rg);
        btnSecond = findViewById(R.id.btnSecond);
        btnThird = findViewById(R.id.btnThird);
        btnOK = findViewById(R.id.btnOK);
        btnCancle = findViewById(R.id.btnCancle);
        chk = findViewById(R.id.chk);
        btn = findViewById(R.id.btn);

        chk.setChecked(true);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)btn.setEnabled(true);
                else btn.setEnabled(false);
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if(i==0)grade="2학년";
//                else grade="3학년";
                if(radioGroup.getCheckedRadioButtonId()==R.id.btnSecond)
                    grade= btnSecond.getText().toString();
                else grade = btnThird.getText().toString();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"선택한 학년:"+grade, Toast.LENGTH_SHORT).show();
            }
        });
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
                Toast.makeText(getApplicationContext(), "선택 취소함", Toast.LENGTH_SHORT).show();
            }
        });

        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}