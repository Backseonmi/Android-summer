package com.cookandroid.and0803_01_carlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    CarAdapter cAdapter;
    ArrayList<Car> cArray;
    Car cItem;
    Integer[] poster = {R.drawable.car1, R.drawable.car2, R.drawable.car3, R.drawable.car4, R.drawable.car5, R.drawable.car6, R.drawable.car7, R.drawable.car8, R.drawable.car9};
    String[] title = {"SM1", "SM2", "SM3", "SM4", "SM5", "SM6", "SM7", "SM8", "SM9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("자동차 커스텀리스트[백선미]");
        list = findViewById(R.id.list);
        cArray = new ArrayList<>();
        for(int i = 0; i<poster.length; i++){
            cItem = new Car(ContextCompat.getDrawable(this, poster[i]), title[i]);
            cArray.add(cItem);
        }//카 객체 배열 초기화(ArrayList에 값으로 생성)
        cAdapter = new CarAdapter(this, cArray);
        list.setAdapter(cAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Car item = (Car)list.getItemAtPosition(i);
                customToast(item);
            }
        });
    } //onCreate()
    public void customToast(Car item){
        View layout = getLayoutInflater().inflate(R.layout.car_toast, null);
        ImageView img = layout.findViewById(R.id.toast_img);
        TextView txt = layout.findViewById(R.id.toast_txt);
        img.setImageDrawable(item.getImage());
        txt.setText(item.getTitle());

        Toast t = new Toast(getApplicationContext());
        t.setView(layout);
        //토스트 위치 지정하기
        t.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        t.setDuration(Toast.LENGTH_SHORT);
        t.show();
    }

}