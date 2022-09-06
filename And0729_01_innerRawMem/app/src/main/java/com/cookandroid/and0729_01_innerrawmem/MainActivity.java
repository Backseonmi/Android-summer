package com.cookandroid.and0729_01_innerrawmem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    Button btnInnerWrite, btnInnerRead, btnRawRead;
    EditText edtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]파일입출력(내장,RAM)");
        btnInnerWrite = findViewById(R.id.btnInnerWrite);
        btnInnerRead = findViewById(R.id.btnInnerRead);
        btnRawRead = findViewById(R.id.btnRawRead);
        edtData = findViewById(R.id.edtData);

        btnInnerWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = openFileOutput("fileTest.txt", Context.MODE_PRIVATE); //MODE_PRIVATE : 파일 쓰기용으로 open
                    String str = "안녕 오늘 극혐이야";
                    //String str2 = edtData.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), "fileTest파일 생성됨", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }
            }
        });
        btnInnerRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream infs = openFileInput("fileTest.txt");
                    byte[] str = new byte[50];
                    infs.read(str); //str.toString()
                    edtData.setText(new String(str));
                    infs.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "파일 없음", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnRawRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream ins = getResources().openRawResource(R.raw.txt_back);
                    byte[] str = new byte[ins.available()];
                    ins.read(str); //str.toString()
                    edtData.setText(new String(str));
                    ins.close();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "파일 없음", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


}