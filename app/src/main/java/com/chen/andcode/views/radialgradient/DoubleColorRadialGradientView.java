package com.chen.andcode.views.radialgradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;

/**
 * 两色渐变View
 * @author zehua_chen
 * create at 2017/2/27 14:39
 */
public class DoubleColorRadialGradientView extends View {

    private Paint mPaint;
    private RadialGradient mRadialGradient;
    /**
     *  半径
     */
    private int radius =  100;

    public DoubleColorRadialGradientView(Context context) {
        this(context, null);
    }

    public DoubleColorRadialGradientView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DoubleColorRadialGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        /**
         *  View级别的关闭硬件加速
         */
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRadialGradient = new RadialGradient(w / 2, h / 2, radius, 0xffff0000, 0xff00ff00, TileMode.REPEAT);
        mPaint.setShader(mRadialGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, mPaint);
    }
}
