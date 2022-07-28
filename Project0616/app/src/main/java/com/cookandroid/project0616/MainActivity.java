package com.cookandroid.project0616;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText number1, number2;
    TextView resultView;
    Button btnPlus, btnMinus, btnMulti;
//    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6 , btn7, btn8, btn9;

    Button[] btnNums = new Button[10];//버튼 객체배열 10개(0~9)
    Integer[] ids = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};//본인 xml의 id이름

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("백선미");
        for (int i = 0; i < btnNums.length; i++) {//0~9버튼 findviewby...
            btnNums[i] = findViewById(ids[i]);

            final int index = i;
            btnNums[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (number1.isFocused()) {
                        String s = number1.getText().toString() + index;
                        number1.setText(s);
                    } else if (number2.isFocused()) {
                        String s = number2.getText().toString() + index;
                        number2.setText(s);
                    } else {
                        Toast.makeText(getApplicationContext(), "에디터부터 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        resultView = findViewById(R.id.resultView);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(number1.getText().toString());
                int y = Integer.parseInt(number2.getText().toString());
                int result = x + y;
                resultView.setText("계산결과: " + result);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(number1.getText().toString());
                int y = Integer.parseInt(number2.getText().toString());
                int result = x - y;
                resultView.setText("계산결과: " + result);
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(number1.getText().toString());
                int y = Integer.parseInt(number2.getText().toString());
                int result = x * y;
                resultView.setText("계산결과: " + result);
            }
        });
    }//onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option, menu);//xml을 메뉴로 생성
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int x = Integer.parseInt(number1.getText().toString());
        int y = Integer.parseInt(number2.getText().toString());
        switch (item.getItemId()) {
            case R.id.itemAdd:
                resultView.setText("계산결과: " + (x + y));
                break;
            case R.id.itemMul:
                resultView.setText("계산결과: " + (x * y));
                break;
            case R.id.itemExit:
                finish();
        }
        return true;
    }
}