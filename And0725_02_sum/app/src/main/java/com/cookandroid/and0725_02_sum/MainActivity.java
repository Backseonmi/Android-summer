package com.cookandroid.and0725_02_sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt_num;
    Button btn_sum;
    TextView result_sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]합구하기");
        edt_num = findViewById(R.id.edt_num);
        btn_sum = findViewById(R.id.btn_sum);
        result_sum = findViewById(R.id.result_sum);

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edt_num.getText().toString());
                int s = 0;
                for (int i = 1; i <= n; i++) s += i;
                result_sum.setText("결과: 1~" + n + "까지의 합 = " + s);
                edt_num.setText("");

            }
        });
    }
}