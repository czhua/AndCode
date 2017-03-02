package com.chen.andcode.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;

import com.chen.andcode.R;
import com.chen.andcode.utils.StringUtils;
import com.chen.andcode.utils.ToolBarHelper;
import com.chen.andcode.views.StatusBarUtil;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrListener;
import com.r0adkll.slidr.model.SlidrPosition;

/**
 * @author zehua_chen
 *         create at 2017/2/27 15:16
 */
public class BaseActivity extends AppCompatActivity {

    private ToolBarHelper mToolBarHelper;
    public Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        initToolbar(layoutResID);
    }


    private void initToolbar(int layoutResID) {
        mToolBarHelper = new ToolBarHelper(this, layoutResID);
        mToolbar = mToolBarHelper.getToolBar();
        setContentView(mToolBarHelper.getContentView());
        setSupportActionBar(mToolbar);
        onCreateCustomToolBar(mToolbar);
        if (!isShowBackBtn()) {
            mToolbar.setNavigationIcon(null);
            StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bg));
        } else {
            Slidr.attach(this);
            StatusBarUtil.setColorForSwipeBack(this, getResources().getColor(R.color.title_bg));
        }
    }

    public void onCreateCustomToolBar(Toolbar toolbar) {
        toolbar.setContentInsetsRelative(0, 0);
    }

    public void setTitle(String titStr) {
        if (StringUtils.isEmpty(titStr)) {
            mToolbar.setTitle(null);
        }
        setTitle(titStr);
    }

    public boolean isShowBackBtn() {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
