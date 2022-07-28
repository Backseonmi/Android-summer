package com.cookandroid.and0726_03_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn_vote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("아이돌 선택[백선미]");
        rg = findViewById(R.id.rg);
        btn_vote = findViewById(R.id.btn_vote);

        btn_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.rad_ITZY:
                        Toast.makeText(getApplicationContext(), "있지", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad_bts:
                        Toast.makeText(getApplicationContext(), "방탄", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad_revelt:
                        Toast.makeText(getApplicationContext(), "레드벨벳", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
    }
}