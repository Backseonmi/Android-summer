package com.cookandroid.and0729_03_sdmem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {
    Button btnRead, btnMkDir, btnDelDir, btnFileList;
    EditText edtSD;
    String strSDPath;
    File myDir; //앱 디렉터리 이름

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnRead = findViewById(R.id.btnRead);
        btnMkDir = findViewById(R.id.btnMkDir);
        btnDelDir = findViewById(R.id.btnDelDir);
        btnFileList = findViewById(R.id.btnFileList);
        edtSD = findViewById(R.id.edtSD);
        //핸드폰의 SD 카드 절대 경로
        strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        myDir = new File(strSDPath + "/myDir"); //앱이름의 폴더 경로 세팅

        btnMkDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!myDir.exists()) myDir.mkdir();
            }
        });

        btnDelDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream infs = new FileInputStream(strSDPath + "/myDir/test.txt"); //년_월_일.txt 파일 읽기
                    byte[] in = new byte[infs.available()];
                    infs.read(in);
                    edtSD.setText(new String(in));
                    infs.close();
                } catch (Exception e) {
                }

            }
        });

        btnFileList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File[] sysFiles = (new File(strSDPath).listFiles());
                String strFname = "파일및 폴더 개수" + sysFiles.length;
                for (int i = 0; i < sysFiles.length; i++) {
                    if(sysFiles[i].isDirectory())
                        strFname += "\n[폴더]" + sysFiles[i].toString();
                    if(sysFiles[i].isFile())
                        strFname += "\n[파일]" + sysFiles[i].toString();
                }
                edtSD.setText(strFname);
            }
        });


    }
}