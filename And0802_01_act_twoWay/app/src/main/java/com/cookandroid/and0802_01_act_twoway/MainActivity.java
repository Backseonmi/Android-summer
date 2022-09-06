package com.cookandroid.and0802_01_act_twoway;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2;
    Button btnResult;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]첫번째 화면");
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btnResult = findViewById(R.id.btnResult);
        rg = findViewById(R.id.rg);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                in.putExtra("Num1", Integer.parseInt(edt1.getText().toString()));
                in.putExtra("Num2", Integer.parseInt(edt2.getText().toString()));
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.rdo_Plus:
                        in.putExtra("op", "+");
                        break;
                    case R.id.rdo_Minus:
                        in.putExtra("op", "-");
                        break;
                    case R.id.rdo_Mul:
                        in.putExtra("op", "*");
                        break;
                    case R.id.rdo_div:
                        in.putExtra("op", "/");
                        break;
                }
                startActivityForResult(in, 0); //requestCode는 세컨액티버티 번호
                //세컨액티비티에 return 값이 있을때 사용(세커에서 되돌려 받는 경우)

            }
        });
    }//onCreate()
    //메서드로 onActivityResult()함수 구현

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int sum = data.getIntExtra("sum", 0);
            Toast.makeText(getApplicationContext(), "합계: " + sum, Toast.LENGTH_SHORT).show();
        }
    }
}