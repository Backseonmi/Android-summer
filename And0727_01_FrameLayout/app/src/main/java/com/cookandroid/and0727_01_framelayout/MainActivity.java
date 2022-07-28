package com.cookandroid.and0727_01_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button Btn;
    ImageView img1, img2;
    int imageIndex = 0;
//    int imgType = 2; //1 = dog, 2 = cat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("프레임 레이아웃[백선미]");
        Btn = findViewById(R.id.Btn);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

//        Btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(imgType ==1){
//                    img1.setImageResource(R.drawable.cat);
//                    imgType = 2;
//                }else{
//                    img1.setImageResource(R.drawable.dog);
//                    imgType = 1;
//                }
//            }
//        });

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage();
            }
        });
    }

    private void changeImage() {
        if (imageIndex == 0) {
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
            imageIndex = 1;
        } else if (imageIndex == 1) {
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
            imageIndex = 0;
        }


    }
}