package com.smktelkom.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveActivityWithObject extends AppCompatActivity {

    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        if (getIntent() != null){
            TextView tvObject = (TextView) findViewById(R.id.tv_object);
            Person manusia = getIntent().getParcelableExtra(EXTRA_PERSON);
            String text = "Name\t: "+manusia.getName()+"\nEmail\t: "+manusia.getEmail()+"\nAge\t\t: "+manusia.getAge()+"\nCity\t\t: "+manusia.getCity();
            tvObject.setText(text);
        }
    }
}