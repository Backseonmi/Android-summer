package com.cookandroid.and0725_03_keylisn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]테스트");
        edt_key = findViewById(R.id.edt_key);

        edt_key.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int j, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                    Toast.makeText(getApplicationContext(), edt_key.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    int n = Integer.parseInt(edt_key.getText().toString());
                    int s = 0;
                    for (int i = 1; i <= n; i++) s += i;
                    String str = "계산 결과: 1~" + n + "까지의 합 = " + s;
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}