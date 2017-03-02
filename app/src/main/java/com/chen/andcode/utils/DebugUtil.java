package com.chen.andcode.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Debug工具类
 * @author zehua_chen
 * create at 2017/3/2 19:35
 */
public class DebugUtil {
    public static final String TAG = "chan";
    public static final boolean DEBUG = true;

    public static void showToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public static void debug(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void debug(String msg) {
        if (DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void error(String tag, String error) {
        if (DEBUG) {
            Log.e(tag, error);
        }
    }

    public static void error(String error) {
        if (DEBUG) {
            Log.e(TAG, error);
        }
    }
}