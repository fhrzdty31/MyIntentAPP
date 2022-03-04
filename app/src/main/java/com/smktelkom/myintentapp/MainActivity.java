package com.smktelkom.myintentapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int REQUEST_CODE = 100;
    private TextView tvResult;

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
        Button btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);
        Button btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.tv_result);
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
            case R.id.btn_dial_number:
                String phoneNumber = "081234567890";
                Intent intent4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(intent4);
                break;
            case R.id.btn_move_for_result:
                Intent intent5 = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(intent5, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requesCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requesCode, resultCode, data);
        if (requesCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil : "+selectedValue);
            }
        }
    }
}