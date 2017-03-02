package com.chen.andcode.other;

import android.os.Bundle;

import com.chen.andcode.R;
import com.chen.andcode.base.BaseActivity;

import butterknife.ButterKnife;

public class ToolBarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        ButterKnife.bind(this);


    }
}
