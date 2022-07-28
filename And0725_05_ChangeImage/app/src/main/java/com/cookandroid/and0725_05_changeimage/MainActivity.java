package com.cookandroid.and0725_05_changeimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn_change, btn_hide;
    ImageView image;
    int imgType = 2; // 1 == dog, 2 == cat //원래 그림 = 강아지, 바꿔지는 그림 = 고양이
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]이미지 바꾸기");
        btn_change = findViewById(R.id.btn_change);
        btn_hide = findViewById(R.id.btn_hide);
        image = findViewById(R.id.image);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgType == 1){
                    image.setImageResource(R.drawable.dog);
                    imgType = 2;
                }else{
                    image.setImageResource(R.drawable.cat1);
                    imgType = 1;
                }
            }
        });
        btn_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (image.getVisibility() == View.VISIBLE) {
                    image.setVisibility(View.INVISIBLE);
                    btn_hide.setText("보이기");
                } else {
                    image.setVisibility(View.VISIBLE);
                    btn_hide.setText("숨기기");
                }
            }
        });
    }
}