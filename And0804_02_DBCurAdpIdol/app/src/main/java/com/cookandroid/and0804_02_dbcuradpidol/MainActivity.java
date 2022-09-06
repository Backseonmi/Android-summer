package com.cookandroid.and0804_02_dbcuradpidol;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNumber;
    Button btnInsert, btnSelected, btnInit;
    ListView listView;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    IdolAdapter IAdapter;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("백선미[커서어댑터_아이돌DB관리]");
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelected = findViewById(R.id.btnSelected);
        btnInit = findViewById(R.id.btnInit);
        listView = findViewById(R.id.listView);
        myHelper = new MyDBHelper(this);

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //DB의 테이블 삭제 후 다시 생성
                sqlDB = myHelper.getWritableDatabase(); //수정모드 오픈
                myHelper.onUpgrade(sqlDB, 1, 2); //숫자의 버전의미로 아무거나
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "초기화됨", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtName = view.findViewById(R.id.txtName);
                TextView txtTel = view.findViewById(R.id.txtTel);
                String out = "이름: " + txtName.getText().toString();
                out += "\n인원 수: " + txtTel.getText().toString();
                Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB = myHelper.getWritableDatabase();
                    String name = edtName.getText().toString().trim();
                    String number = edtNumber.getText().toString().trim();
                    if(!name.isEmpty()&&!number.isEmpty()){
                        String sql = "INSERT INTO contactTBL(name, tel) VALUES ('"+name+"', '"+number+"');";
                        sqlDB.execSQL(sql);
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                        edtName.setText(""); edtNumber.setText("");
                        btnInsert.callOnClick();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("SELECT * FROM contactTBL;", null);
                if(cursor.getCount()>0) {
                    IAdapter = new IdolAdapter(MainActivity.this, cursor, true);

                    listView.setAdapter(IAdapter);
                }
                else { //초기화 되어 테이블이 없는 경우 adapter 초기화시킴
                    IAdapter=null;
                    listView.setAdapter(IAdapter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"조회됨",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onStop(){
        super.onStop();
        cursor.close();
    }
}