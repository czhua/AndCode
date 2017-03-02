package com.chen.andcode.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chen.andcode.R;
import com.chen.andcode.utils.ObjectUtils;
import com.chen.andcode.utils.StringUtils;

/**
 * Created by zehua_chen on 2017/3/1.
 */

public class SubToolBar {

    private Context mContext;
    /**
     * 自定义View
     */
    private View custView;
    private Toolbar mToolBar;
    private LayoutInflater mInflater;
    private FrameLayout mContentView;

    /**
     * 两个属性
     * 1、toolbar是否悬浮在窗口之上
     * 2、toolbar的高度获取
     */
    private static int[] ATTRS = {
            R.attr.windowActionBarOverlay,
            R.attr.actionBarSize
    };

    public SubToolBar(Context context, int layoutId) {
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        /*初始化整个内容*/
        initContentView();
        /*初始化用户定义的布局*/
        initCustView(layoutId);
        /*初始化toolbar*/
        initToolBar();
    }

    private void initContentView() {
        mContentView = new FrameLayout(mContext);
        ViewGroup.LayoutParams params =
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        mContentView.setLayoutParams(params);

    }

    private void initToolBar() {
        View toolbar = mInflater.inflate(R.layout.toolbar, mContentView);
        mToolBar = (Toolbar) toolbar.findViewById(R.id.id_tool_bar);
    }

    /**
     * 初始化自定义View
     *
     * @param layoutId 自定义View的id
     */
    private void initCustView(int layoutId) {
        if (0 == layoutId) {
            return;
        }
        custView = mInflater.inflate(layoutId, null);
        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(ATTRS);
        // 获取主题中定义的悬浮标志
        boolean overly = typedArray.getBoolean(0, false);
        // 获取主题中定义的toolbar的高度
        int toolBarSize = (int) typedArray.getDimension(
                1,
                (int) mContext.getResources().getDimension(
                        R.dimen.abc_action_bar_default_height_material));
        typedArray.recycle();
        // 如果是悬浮状态，则不需要设置间距
        params.topMargin = overly ? 0 : toolBarSize;
        mContentView.addView(custView, params);

    }

    public FrameLayout getContentView() {
        return mContentView;
    }

    public Toolbar getToolBar() {
        return mToolBar;
    }

    public void setNavigationIcon(int iconId) {
        mToolBar.setNavigationIcon(iconId);
    }

    public static class Builder {

        private SubToolBar mSubToolBar;
        private Context context;
        private String titStr;
        private String titSubStr;
        private int titLeftImg;
        private int titRightImg;
        private int layoutId;
        private int navigationImg;
        private int logoImg;
        private int menuId;
        private Toolbar.OnMenuItemClickListener onMenuItemClickListener;
        private int titColor;
        private int titSubColor;
        private int titAppeaStyle;
        private int titSubAppeaStyle;

        public Builder(Context context) {
            this.context = context;
        }

        public SubToolBar create() {
            if (null == context) {
                return null;
            }
            if (0 == layoutId) {
                return null;
            }
            mSubToolBar = new SubToolBar(context, layoutId);

            if(!StringUtils.isEmpty(titStr)) {
                mSubToolBar.mToolBar.setTitle(titStr);
            }
            if(!StringUtils.isEmpty(titSubStr)) {
                mSubToolBar.mToolBar.setSubtitle(titSubStr);
            }
            if(0 != navigationImg) {
                mSubToolBar.mToolBar.setNavigationIcon(navigationImg);
            }
            if(0 != logoImg) {
                mSubToolBar.mToolBar.setLogo(logoImg);
            }
            if(0 != menuId) {
                mSubToolBar.mToolBar.inflateMenu(menuId);
            }
            if(0 != titColor) {
                mSubToolBar.mToolBar.setTitleTextColor(titColor);
            } else {
                mSubToolBar.mToolBar.setTitleTextColor(Color.WHITE);
            }
            if(0 != titSubColor) {
                mSubToolBar.mToolBar.setSubtitleTextColor(titSubColor);
            } else {
                mSubToolBar.mToolBar.setSubtitleTextColor(Color.WHITE);
            }
            if(0 != titAppeaStyle) {
                mSubToolBar.mToolBar.setTitleTextAppearance(context, titAppeaStyle);
            }
            if(0 != titSubAppeaStyle) {
                mSubToolBar.mToolBar.setSubtitleTextAppearance(context, titSubAppeaStyle);
            }
            if(null != onMenuItemClickListener) {
                mSubToolBar.mToolBar.setOnMenuItemClickListener(onMenuItemClickListener);
            }

            return mSubToolBar;

        }
    }


}
