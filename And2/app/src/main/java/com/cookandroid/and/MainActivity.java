package com.cookandroid.and;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtName;//////
    Button btnOK;
    EditText edX,edY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        btnOK = findViewById(R.id.btn);
        edY = findViewById(R.id.edy);
        edX = findViewById(R.id.edx);
        btnOK.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(txtName.getText().equals("미림"))
                    txtName.setText("과학고");
                else txtName.setText("미림");
                String strX = edX.getText().toString();
                String strY = edY.getText().toString();
                int result = Integer.parseInt(strX) + Integer.parseInt(strY);
                Toast.makeText(getApplicationContext(),
                        "더하기결과 :" + result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}