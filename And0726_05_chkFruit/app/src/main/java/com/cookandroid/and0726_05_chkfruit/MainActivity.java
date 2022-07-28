package com.cookandroid.and0726_05_chkfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox[] chkList = new CheckBox[4];
    Integer[] chkText = {R.id.straw, R.id.grape, R.id.kiwi, R.id.Grpfrt};
    Button Btn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("과일 선택[백선미]");
        Btn = findViewById(R.id.Btn);
        result = findViewById(R.id.result);
        for (int i = 0; i < chkList.length; i++) chkList[i] = findViewById(chkText[i]);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = " ";
                for (int i = 0; i < chkList.length; i++) {
                    if (chkList[i].isChecked() == true) {
                        str += (chkList[i].getText().toString());
                    }
                }
                if(str.equals("")) result.setText("선택하지 않았습니다.");
                else result.setText("선택결과: " + str);
            }
        });
        ///////////////////////////추가//////////////////////////////////////////////////////////////
        for (int i = 0; i < chkList.length; i++) {
            final int k = i;
            chkList[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                    String str = " ";
//                    for (int i = 0; i < chkList.length; i++) {
//                        if (chkList[i].isChecked() == true) {
//                            str += (chkList[i].getText().toString());
//                        }
//                    }
//                    result.setText("선택결과: " + str);
                    Btn.performClick(); //위 줄을 한 줄로 줄일 수 있음(=Btn의 Onclick 함수 호출한 것과 똑같은 역할)
                }
            });

        }


    }
}