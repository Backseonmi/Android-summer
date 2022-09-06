package com.cookandroid.and0728_05_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtId, edtTel;
    Button btn_OK, btn_Cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("로그인 다이얼[백선미]");
        edtId = findViewById(R.id.edtId);
        edtTel = findViewById(R.id.edtTel);
        btn_OK = findViewById(R.id.btn_OK);
        btn_Cancle = findViewById(R.id.btn_Cancle);

        btn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("로그인정보");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                dlg.setMessage("비밀번호: " + edtTel.getText().toString() +"\n" + "아이디: " + edtId.getText().toString());
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "확인을 눌렀네요 하하~", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

        btn_Cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_button, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.context_cancle:
                                Toast.makeText(getApplicationContext(), "초기화 합니다", Toast.LENGTH_SHORT).show();
                                edtId.setText("");
                                edtTel.setText("");
                                return false;
                            case R.id.context_end:
                                Toast.makeText(getApplicationContext(), "종료 합니다", Toast.LENGTH_SHORT).show();
                                finish();
                                return false;
                            default:
                                Toast.makeText(getApplicationContext(), "선택안됨", Toast.LENGTH_SHORT).show();
                                return false;
                        }

                    }
                });
                p.show();
            }
        });


    }
}