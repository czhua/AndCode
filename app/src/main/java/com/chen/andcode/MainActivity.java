package com.chen.andcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;

import com.chen.andcode.anim.AnimActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toAnimActivity(View view) {
        Intent intent = new Intent(this, AnimActivity.class);
        startActivity(intent);
    }
}
