package com.smktelkom.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        Button btnMoveActivityData = findViewById(R.id.btn_move_activity_data);
        btnMoveActivityData.setOnClickListener(this);
        Button btnMoveActivityObject = findViewById(R.id.btn_move_activity_object);
        btnMoveActivityObject.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case  R.id.btn_move_activity:
                Intent intent1 = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_move_activity_data:
                Intent intent2 = new Intent(MainActivity.this, MoveActivity.class);
                intent2.putExtra("data1", "somestring data");
                intent2.putExtra("data2", "somestring data2");
                startActivity(intent2);
                break;
            case R.id.btn_move_activity_object:
                Person manusia = new Person("Fahreza Ditya Alfandry", "fahreza@gmail.com", "Kediri", 17);
                Intent intent3 = new Intent(MainActivity.this, MoveActivityWithObject.class);
                intent3.putExtra(MoveActivityWithObject.EXTRA_PERSON, manusia);
                startActivity(intent3);
                break;
        }
    }
}