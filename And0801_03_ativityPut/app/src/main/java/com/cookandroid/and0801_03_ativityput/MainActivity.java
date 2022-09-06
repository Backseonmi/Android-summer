package com.cookandroid.and0801_03_ativityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edt_Name, edt_Age;
    CheckBox chk_game, chk_music, chk_exercise;
    Button btnIn;
    String name;
    int age, index = 0;
    CheckBox[] chk = new CheckBox[3];
    Integer[] chkString = {R.id.chk_game, R.id.chk_music, R.id.chk_music};
    ArrayList<String> hobby = new ArrayList<>(); //동적 객체배열>>제네릭 구조

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]첫번째 화면");
        edt_Name = findViewById(R.id.edt_Name);
        edt_Age = findViewById(R.id.edt_Age);
        chk_game = findViewById(R.id.chk_game);
        chk_music = findViewById(R.id.chk_music);
        chk_exercise = findViewById(R.id.chk_exercise);

        btnIn = findViewById(R.id.btnIn);
        for (int i = 0; i < chkString.length; i++) {
            final int index = i;
            chk[i] = findViewById(chkString[i]);
            chk[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) hobby.add(chk[index].getText().toString()); //배열추가
                    else hobby.remove(chk[index].getText().toString());//배열삭제
                }
            });
        }
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edt_Name.getText().toString();
                age = Integer.parseInt(edt_Age.getText().toString());
                Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                in.putExtra("name", name);
                in.putExtra("age", age);
                in.putExtra("hobby", hobby);
                startActivity(in);
            }
        });
    }
}