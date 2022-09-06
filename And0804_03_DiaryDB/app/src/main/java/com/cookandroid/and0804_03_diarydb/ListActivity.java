package com.cookandroid.and0804_03_diarydb;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    MyDBHelper myHelper;
    Cursor cursor;
    SQLiteDatabase sqlDB;
    DiaryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        listView = findViewById(R.id.listView);
        myHelper = new MyDBHelper(this);
        sqlDB = myHelper.getReadableDatabase();
        cursor = sqlDB.rawQuery("SELECT * FROM DiaryTBL order by diaryDate desc;",null);
        if (cursor.getCount()>0){
            adapter = new DiaryAdapter(ListActivity.this, cursor,true);
            listView.setAdapter(adapter);
        }else{
            adapter=null;
            listView.setAdapter(adapter);
            Toast.makeText(getApplicationContext(),"일기없음",Toast.LENGTH_SHORT).show();
        }
        sqlDB.close();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtName = view.findViewById(R.id.txtName);
                Intent in = new Intent(getApplicationContext(),DiaryActivity.class);
                in.putExtra("fname",txtName.getText().toString());
                startActivity(in);
                finish();
            }
        });
    }
}
