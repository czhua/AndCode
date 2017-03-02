package com.chen.andcode.views;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chen.andcode.R;

/**
 * 
 * @Description: 
 * title 
 * @Author douxy
 * @Date 2015年8月11日 下午2:02:54
 */
public abstract class SubTitle implements OnClickListener {

    /**外围layout*/
    public RelativeLayout sub_title_rl;

    public ImageView title_left_bt;
    public TextView title_left_tv;

    public TextView title_center_tv;
    public ImageView title_right_bt;
    public TextView title_right_tv;

    private View sub_title_bottom_line;

    public SubTitle(View view) {
        sub_title_rl = (RelativeLayout) view.findViewById(R.id.sub_title_rl);
        title_left_bt = (ImageView) view.findViewById(R.id.sub_title_left_bt);
        title_left_tv = (TextView) view.findViewById(R.id.sub_title_left_tv);
        title_center_tv = (TextView) view.findViewById(R.id.sub_title_center_tv);
        title_right_bt = (ImageView) view.findViewById(R.id.sub_title_right_bt);
        title_right_tv = (TextView) view.findViewById(R.id.sub_title_right_tv);
        sub_title_bottom_line = view.findViewById(R.id.sub_title_bottom_line);
        this.setOnClickListener(this);
    }

    public SubTitle showBottomLine() {
        sub_title_bottom_line.setVisibility(View.VISIBLE);
        return this;
    }

    public SubTitle hideBottomLine() {
        sub_title_bottom_line.setVisibility(View.GONE);
        return this;
    }

    /**
     * 隐藏按钮
     * 
     * @return
     */
    public SubTitle hideBtns() {
        title_left_bt.setVisibility(View.GONE);
        title_left_tv.setVisibility(View.GONE);
      //  title_right_bt.setVisibility(View.GONE); // 添加计算器按钮时注释的
        title_right_tv.setVisibility(View.GONE);
        return this;
    }

    public SubTitle showLeftBtn() {
        title_left_bt.setVisibility(View.VISIBLE);
        title_left_tv.setVisibility(View.GONE);
        title_right_bt.setVisibility(View.GONE); // 添加计算器按钮时注释的
        title_right_tv.setVisibility(View.GONE);
        return this;
    }

    public SubTitle showRightBtn() {
        title_left_bt.setVisibility(View.GONE);
        title_left_tv.setVisibility(View.GONE);
        title_right_bt.setVisibility(View.VISIBLE);
        title_right_tv.setVisibility(View.GONE);
        return this;
    }

    public SubTitle showLeftRightBtn() {
        title_left_bt.setVisibility(View.VISIBLE);
        title_left_tv.setVisibility(View.GONE);
        title_right_bt.setVisibility(View.VISIBLE);
        title_right_tv.setVisibility(View.GONE);
        return this;
    }

    public SubTitle showLeftTvRightBtn() {
        title_left_bt.setVisibility(View.GONE);
        title_left_tv.setVisibility(View.VISIBLE);
        title_right_bt.setVisibility(View.VISIBLE);
        title_right_tv.setVisibility(View.GONE);
        return this;
    }

    /**
     * 显示按钮
     * 
     * @return
     */
    public SubTitle showBtns() {
        title_left_bt.setVisibility(View.VISIBLE);
        title_left_tv.setVisibility(View.VISIBLE);
        title_right_bt.setVisibility(View.VISIBLE);
        title_right_tv.setVisibility(View.VISIBLE);
        return this;
    }

    public SubTitle setOnClickListener(OnClickListener l) {
        if (sub_title_rl != null) {
            title_left_bt.setOnClickListener(l);
            title_left_tv.setOnClickListener(l);
            title_center_tv.setOnClickListener(l);
            title_right_bt.setOnClickListener(l);
            title_right_tv.setOnClickListener(l);
        }
        return this;
    }

    /**
     * 设置背景颜色
     * @param color
     */
    public SubTitle setBgColor(int color) {
        sub_title_rl.setBackgroundColor(color);
        return this;
    }

    /**
     * 设置子体色
     * 
     * @param color
     * @return
     */
    public SubTitle setColor(int color) {
        title_left_tv.setTextColor(color);
        title_center_tv.setTextColor(color);
        title_right_tv.setTextColor(color);
        return this;
    }

    /**
     * 设置 标题
     * @param title
     */
    public SubTitle setTitle(String title) {
        title_center_tv.setText(title);
        return this;
    }

    /**
     * 设置左侧按钮名称
     * 
     * @param name
     */
    public SubTitle setLeftName(String name) {
        title_left_tv.setText(name);
        return this;
    }

    /**
     * 设置右侧按钮名称
     * 
     * @param name
     * @return
     */
    public SubTitle setRightName(String name) {
        title_right_tv.setText(name);
        return this;
    }

    /**
     * 点击右侧按钮事件
     * @param v
     */
    protected abstract void clickRightBtn(View v);

    /**
     * 点击左侧按钮事件
     * @param v
     */
    protected abstract void cickLeftBtn(View v);

    /**
     * 点击标题事件
     * @param v
     */
    protected abstract void clickTitle(View v);

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.sub_title_center_tv:
            clickTitle(v);
            break;
        case R.id.sub_title_left_bt:
        case R.id.sub_title_left_tv:
            cickLeftBtn(v);
            break;
        case R.id.sub_title_right_bt:
        case R.id.sub_title_right_tv:
            clickRightBtn(v);
            break;
        default:
            break;
        }

    }

}
