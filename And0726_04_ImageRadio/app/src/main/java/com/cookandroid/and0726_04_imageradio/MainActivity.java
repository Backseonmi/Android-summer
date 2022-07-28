package com.cookandroid.and0726_04_imageradio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    Button btn_word, btn_home;
    RadioGroup rg;
    RadioButton rdo_kitkat, rdo_oreo;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("[백선미]이미지 바꾸기");
        edt = findViewById(R.id.edt);
        btn_word = findViewById(R.id.btn_word);
        btn_home = findViewById(R.id.btn_home);
        rg = findViewById(R.id.rg);
        rdo_kitkat = findViewById(R.id.rdo_kitkat);
        rdo_oreo = findViewById(R.id.rdo_oreo);
        img = findViewById(R.id.img);

        btn_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edt.getText().toString();
                Toast.makeText(getApplicationContext(), "입력한 결과: " + str, Toast.LENGTH_SHORT).show();

            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlOpen = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"));
                startActivity(urlOpen);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rdo_kitkat: img.setImageResource(R.drawable.kitkat); break;
                    case R.id.rdo_oreo: img.setImageResource(R.drawable.oreo); break;
                }

            }
        });

    }
}