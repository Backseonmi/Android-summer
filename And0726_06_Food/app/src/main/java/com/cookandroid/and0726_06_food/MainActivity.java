package com.cookandroid.and0726_06_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    CheckBox btn_start;
    RadioGroup rg;
    RadioButton rdoKorean, rdoChinese, rdoSimple, rdoNight;
    Button Btn;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배달 음식 선호도 조사[백선미]");
        text = findViewById(R.id.text);
        btn_start = findViewById(R.id.btn_start);
        rg = findViewById(R.id.rg);
        rdoKorean = findViewById(R.id.rdoKorean);
        rdoChinese = findViewById(R.id.rdoChinese);
        rdoSimple = findViewById(R.id.rdoSimple);
        rdoNight = findViewById(R.id.rdoNight);
        Btn = findViewById(R.id.Btn);
        img = findViewById(R.id.img);

        btn_start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(btn_start.isChecked()){
                    text.setVisibility((View.VISIBLE));
                    rg.setVisibility((View.VISIBLE));
                    Btn.setVisibility((View.VISIBLE));
                    img.setVisibility((View.VISIBLE));
                }else{
                    text.setVisibility((View.INVISIBLE));
                    rg.setVisibility((View.INVISIBLE));
                    Btn.setVisibility((View.INVISIBLE));
                    img.setVisibility((View.INVISIBLE));
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rdoKorean: img.setImageResource(R.drawable.dog); break;
                    case R.id.rdoChinese: img.setImageResource(R.drawable.icon2); break;
                    case R.id.rdoSimple: img.setImageResource(R.drawable.lollipop); break;
                    case R.id.rdoNight: img.setImageResource(R.drawable.rabbit); break;
                }

            }
        });

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
                img.setImageDrawable(null);
            }
        });


    }
}