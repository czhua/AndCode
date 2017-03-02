package com.chen.andcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;

import com.chen.andcode.anim.AnimActivity;
import com.chen.andcode.base.BaseActivity;
import com.chen.andcode.other.ToolBarActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toAnimActivity(View view) {
        Intent intent = new Intent(this, AnimActivity.class);
        startActivity(intent);
    }

    public void toToolBarActivity(View view) {
        Intent intent = new Intent(this, ToolBarActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean isShowBackBtn() {
        return false;
    }
}
