package com.cookandroid.and0727_02_lineartest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtX, edtY;
    Spinner op;
    Button btn;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("x값 y값 계산하기[백선미]");
        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);
        op = findViewById(R.id.op);
        btn = findViewById(R.id.btn);
        txtResult = findViewById(R.id.txtResult);
        op.setSelection(0); //기본을 더하기로 초기화
        txtResult.setTextSize(20);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = op.getSelectedItemPosition(); //index로 return하기
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                switch (i){
                    case 0: txtResult.setText(""+(x+y)); break;
                    case 1: txtResult.setText(""+(x-y)); break;
                    case 2: txtResult.setText(""+(x*y)); break;
                    case 3: txtResult.setText(""+(x%y)); break;
                }
            }
        });


    }
}