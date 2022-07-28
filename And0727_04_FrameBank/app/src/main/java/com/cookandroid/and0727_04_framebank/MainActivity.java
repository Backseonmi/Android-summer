package com.cookandroid.and0727_04_framebank;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_leftMon, btn_putMon, btn_takeMon, btn_Input, btn_Output;
    LinearLayout LeftMoney, PutMoney, TakeMoney;
    TextView NowBalance;
    EditText InputMon, OutputMon;
    
    int Balance = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("잔액,입금,출금[백선미]");
        btn_leftMon = findViewById(R.id.btn_leftMon);
        btn_putMon = findViewById(R.id.btn_putMon);
        btn_Input = findViewById(R.id.btn_Input);
        btn_Output = findViewById(R.id.btn_Output);
        LeftMoney = findViewById(R.id.LeftMoney);
        PutMoney = findViewById(R.id.PutMoney);
        TakeMoney = findViewById(R.id.TakeMoney);
        NowBalance = findViewById(R.id.NowBalance);
        InputMon = findViewById(R.id.InputMon);
        OutputMon = findViewById(R.id.OutputMon);
        btn_takeMon = findViewById(R.id.btn_takeMon);

        btn_leftMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_leftMon.setBackgroundColor(Color.parseColor("#3BD6C7"));
                btn_putMon.setBackgroundColor(Color.parseColor("#B5B2B6"));
                btn_Input.setBackgroundColor(Color.parseColor("#B5B2B6"));
                LeftMoney.setVisibility(View.VISIBLE);
                PutMoney.setVisibility(View.INVISIBLE);
                TakeMoney.setVisibility(View.INVISIBLE);

            }
        });

        btn_putMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_leftMon.setBackgroundColor(Color.parseColor("#B5B2B6"));
                btn_putMon.setBackgroundColor(Color.parseColor("#3BD6C7"));
                btn_Input.setBackgroundColor(Color.parseColor("#B5B2B6"));
                LeftMoney.setVisibility(View.INVISIBLE);
                PutMoney.setVisibility(View.VISIBLE);
                TakeMoney.setVisibility(View.INVISIBLE);

            }
        });

        btn_takeMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_leftMon.setBackgroundColor(Color.parseColor("#B5B2B6"));
                btn_putMon.setBackgroundColor(Color.parseColor("#B5B2B6"));
                btn_Input.setBackgroundColor(Color.parseColor("#3BD6C7"));
                LeftMoney.setVisibility(View.INVISIBLE);
                PutMoney.setVisibility(View.INVISIBLE);
                TakeMoney.setVisibility(View.VISIBLE);

            }
        });

        btn_Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(InputMon.getText().toString());
                Balance += x;
                Toast.makeText(getApplicationContext(), "입금완료", Toast.LENGTH_SHORT).show();
                InputMon.setText(" ");
                NowBalance.setText("잔액: " + Balance);
                
            }
        });


        btn_Output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(OutputMon.getText().toString());
                Balance -= x;
                Toast.makeText(getApplicationContext(), "출금완료", Toast.LENGTH_SHORT).show();
                OutputMon.setText(" "); //EditText에 입력한 값 초기화
                NowBalance.setText("잔액: " + Balance);

            }
        });



    }
}