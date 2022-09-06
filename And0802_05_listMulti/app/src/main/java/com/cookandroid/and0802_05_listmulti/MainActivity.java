package com.cookandroid.and0802_05_listmulti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtData;
    Button btnAdd, btnDelete;
    ListView list;
    ArrayList<String> data = new ArrayList<>(); //String 동적 객체배열
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[백선미]리스트뷰");
        edtData = findViewById(R.id.edtData);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        list = findViewById(R.id.list);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, data);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.add(edtData.getText().toString());
                adapter.notifyDataSetChanged(); //데이터 추가로 새로고침(리프레시)
                edtData.setText("");
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                SparseBooleanArray sbArray = list.getCheckedItemPositions();
                if (sbArray.size() != 0) {
                    for (int i = list.getCount() - 1; i >= 0; i--)
                        if (sbArray.get(i)) {
                            str += data.get(i) + " ";
                            data.remove(i);
                        }
                    list.clearChoices();
                    adapter.notifyDataSetChanged(); //데이터 추가로 새로고침(리프레시)
                }
                Toast.makeText(getApplicationContext(), "삭제되었습니다: " + str, Toast.LENGTH_SHORT).show();
            }
        });
        ///////////엔터키를 쳐야 실행됨/////////////////
        edtData.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) { //enter키를 쳐야 실행 되도록
                    data.add(edtData.getText().toString());
                    adapter.notifyDataSetChanged(); //데이터 추가로 새로고침(리프레시)
                    edtData.setText("");
                }
                return true;
            }
        });

    }
}