package com.cookandroid.and0728_03_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button btnTel;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("옵션메뉴 사진 바꾸기[백선미]");
        img = findViewById(R.id.img);
        btnTel = findViewById(R.id.btnTel);
        txt = findViewById(R.id.txt);

        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("성별 선택 확인");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final View dlgView = (View)View.inflate(MainActivity.this, R.layout.dlg, null) ;
                dlg.setView(dlgView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edtName = dlgView.findViewById(R.id.edtName);
                        EditText edtTel = dlgView.findViewById(R.id.edtTel);
                        String str = "이름 : " + edtName.getText().toString() + "\n" + "전화번호 : " + edtTel.getText().toString();
                        txt.setText(str);
                    }
                });
                dlg.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.main_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_dog:
                img.setImageResource(R.drawable.dog);
                return true;
            case R.id.option_cat:
                img.setImageResource(R.drawable.cat);
                return true;
            case R.id.option_rabbit:
                img.setImageResource(R.drawable.rabbit);
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택안됨", Toast.LENGTH_SHORT).show();
                return false;

        }
    }
}