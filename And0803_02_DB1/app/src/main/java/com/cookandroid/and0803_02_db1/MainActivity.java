package com.cookandroid.and0803_02_db1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNumber;
    TextView txtNameResult, txtNumberResult;
    Button btnClear, btnInsert, btnSelected, btnUpdate, btnDelete;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]가수그룹관리DB실습");
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        txtNameResult = findViewById(R.id.txtNameResult);
        txtNumberResult = findViewById(R.id.txtNumberResult);
        btnClear = findViewById(R.id.btnClear);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelected = findViewById(R.id.btnSelected);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        myHelper = new MyDBHelper(this);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //DB의 테이블 삭제 후 다시 생성
                sqlDB = myHelper.getWritableDatabase(); //수정모드 오픈
                myHelper.onUpgrade(sqlDB, 1, 2); //숫자의 버전의미로 아무거나
                sqlDB.close();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = edtName.getText().toString().trim();
                    int num = Integer.parseInt(edtNumber.getText().toString().trim());
                    if (name.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "이름입력필수", Toast.LENGTH_SHORT).show();
                    } else {
                        sqlDB = myHelper.getWritableDatabase(); //수정모드 오픈
                        sqlDB.execSQL("insert into groupTBL(gName, gNumber) values('" + name + "', " + num + ");");
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력성공", Toast.LENGTH_SHORT).show();
                        edtName.setText("");
                        edtNumber.setText("");
                        btnSelected.callOnClick(); //btnSelected() 함수 호출
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "입력실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("select * from groupTBL;", null);
                String strNames = "그룹이름\t\n" + "-------------\n\n";
                String strNums = "인원수\t\n" + "-------------\n\n";
                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\n";
                    strNums += cursor.getInt(1) + "\n";
                }
                txtNameResult.setText(strNames);
                txtNumberResult.setText(strNums);
                cursor.close();
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회성공", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(), R.layout.delete, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 삭제");
                dlg.setView(v);
                final EditText edtDelGName = v.findViewById(R.id.edtDelName);
                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtDelGName.getText().toString().trim();
                            if (!name.isEmpty()) {
                                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '" + name + "';");
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();
                                btnSelected.callOnClick();
                            } else {
                                Toast.makeText(getApplicationContext(), "이름을 입력하세요", Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "삭제실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(), R.layout.updata, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 정보 수정");
                dlg.setView(v);
                final EditText edtUpdateGName = v.findViewById(R.id.edtUpdateName);
                final EditText edtUpdateGNumber = v.findViewById(R.id.edtUpdateNumber);
                dlg.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtUpdateGName.getText().toString().trim();
                            int number = Integer.parseInt(edtUpdateGNumber.getText().toString().trim());
                            if (!name.isEmpty()) {
                                String sql = "UPDATE groupTBL SET gNumber =" + number + " WHERE gName ='" + name + "'";
                                sqlDB.execSQL(sql);
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(), "수정됨", Toast.LENGTH_SHORT).show();
                                btnSelected.callOnClick();
                            } else {
                                Toast.makeText(getApplicationContext(), "이름과 인원을 입력 하세요.", Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "수정실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
    }
}