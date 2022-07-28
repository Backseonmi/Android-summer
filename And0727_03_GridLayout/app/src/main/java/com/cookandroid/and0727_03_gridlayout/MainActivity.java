package com.cookandroid.and0727_03_gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    RadioGroup rg;
    RadioButton Seapasta, Tomapasta, Crmpasta;
    Button btn_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("파스타 선택[백선미]");
        img = findViewById(R.id.img);
        rg = findViewById(R.id.rg);
        Seapasta = findViewById(R.id.Seapasta);
        Tomapasta = findViewById(R.id.Tomapasta);
        Crmpasta = findViewById(R.id.Crmpasta);
        btn_result = findViewById(R.id.btn_result);

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.Seapasta:
                        Toast.makeText(getApplicationContext(), "해물파스타(9,500원)", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Tomapasta:
                        Toast.makeText(getApplicationContext(), "토마토파스타(9,000원)", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Crmpasta:
                        Toast.makeText(getApplicationContext(), "까르보나라파스타(9,500원)", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.Seapasta: img.setImageResource(R.drawable.pic1); break;
                    case R.id.Tomapasta: img.setImageResource(R.drawable.pic2); break;
                    case R.id.Crmpasta: img.setImageResource(R.drawable.pic3); break;
                }
            }
        });


    }
}