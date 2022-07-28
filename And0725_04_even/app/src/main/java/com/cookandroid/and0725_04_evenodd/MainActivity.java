package com.cookandroid.and0725_04_evenodd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt_first, edt_last;
    Button btn_Evensum, btn_Point;
    TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]짝수,포인트 구하기");
        edt_first = findViewById(R.id.edt_first);
        edt_last = findViewById(R.id.edt_last);
        btn_Evensum = findViewById(R.id.btn_Evensum);
        btn_Point = findViewById(R.id.btn_Point);
        txt_result = findViewById(R.id.txt_result);

        btn_Evensum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edt_first.getText().toString());
                int y = Integer.parseInt(edt_last.getText().toString());
                int result = 0;
                for (int i = x; i <= y; i++) if (i % 2 == 0) result += i;
                txt_result.setText(x + "~" + y + "까지 짝수의 합 결과:" + result);
            }
        });

        btn_Point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edt_first.getText().toString()); //포인터 기준
                int y = Integer.parseInt(edt_last.getText().toString()); //내 포인터
                int result = y - y % x;
                if (y < x) txt_result.setText("가용할 포인터가 부족합니다.");
                else txt_result.setText("가용 포인터는" + result + "원 입니다.");
            }
        });

    }
}