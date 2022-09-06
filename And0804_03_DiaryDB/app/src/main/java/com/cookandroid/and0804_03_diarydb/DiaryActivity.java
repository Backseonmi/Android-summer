package com.cookandroid.and0804_03_diarydb;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DiaryActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite, btnDelete;
    String fileName; MyDBHelper myHelper; SQLiteDatabase sqlDB;
    int cYear, cMonth, cDay; Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
        setTitle("[일기장 SQLite] 백선미");
        dp = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnWrite = findViewById(R.id.btnWrite);
        btnDelete = findViewById(R.id.btnDelete);

        Intent in = getIntent();
        String fname = in.getStringExtra("fname");
        String[] arr = fname.split("_");//"_"문자로 분리>> 문자배열 처리

        cYear=Integer.parseInt(arr[0]);
        cMonth=Integer.parseInt(arr[1])-1;
        cDay=Integer.parseInt(arr[2]);
        myHelper=new MyDBHelper(this);
        fileName = cYear+"_"+(cMonth+1)+"_"+(cDay);
        String str = readDiary(fileName);
        edtDiary.setText(str);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                fileName = y + "_" + (m + 1) + "_" + d;
                String str = readDiary(fileName);//일기 있으면 읽어오기
                edtDiary.setText(str);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("delete from DiaryTBL where diaryDate='"+fileName+"';");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();
                    edtDiary.setText("");
                    btnWrite.setText("새로저장"); btnDelete.setVisibility(View.GONE);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "삭제 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnWrite.getText().toString().equals("새로저장")){//insert 처리
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO DiaryTBL(diaryDate, content)"+"VALUES('"+fileName+"', '"+edtDiary.getText().toString()+"');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"입력됨",Toast.LENGTH_SHORT).show();
                    btnWrite.setText("수정하기");
                    btnDelete.setVisibility(View.VISIBLE);
                }else{//update 처리
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("UPDATE DiaryTBL SET content = '"+edtDiary.getText().toString()+"' WHERE diaryDate = '" + fileName + "';");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"수정됨",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public String readDiary(String fName){
        String diaryStr = null;
        sqlDB = myHelper.getReadableDatabase();

        cursor= sqlDB.rawQuery("SELECT * FROM DiaryTBL WHERE diaryDate = '"+fName+"';",null);

        if (cursor.moveToFirst()){
            diaryStr = cursor.getString(2);
            btnWrite.setText("수정하기");
            btnDelete.setVisibility(View.VISIBLE);
        }else{
            btnDelete.setVisibility(View.GONE);//삭제 버튼 없애기
            btnWrite.setText("새로저장");
        }
        cursor.close();
        sqlDB.close();
        return diaryStr;
    }

}
