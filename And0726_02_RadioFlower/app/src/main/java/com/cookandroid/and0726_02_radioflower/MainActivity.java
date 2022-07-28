package com.cookandroid.and0726_02_radioflower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton btnRose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]체크박스실습");
        btnRose = findViewById(R.id.btnRose);
        rg = findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.btnRose:
                        Toast.makeText(getApplicationContext(), "장미입니다", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btnFanzy:
                        Toast.makeText(getApplicationContext(), "팬지입니다", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btnlily:
                        Toast.makeText(getApplicationContext(), "백합입니다", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
    }




    public void onRadioBtnClick(View v) {
        boolean chk = ((RadioButton) v).isChecked();
        if (chk) {
            Toast.makeText(getApplicationContext(), ((RadioButton) v).getText() + "선택", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), ((RadioButton) v).getText() + "취소", Toast.LENGTH_SHORT).show();
    }
}