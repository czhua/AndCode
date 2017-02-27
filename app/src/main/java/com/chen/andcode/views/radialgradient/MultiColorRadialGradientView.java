package com.chen.andcode.views.radialgradient;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Switch;

import com.chen.andcode.R;

/**
 * 多色渐变View
 *
 * @author zehua_chen
 *         create at 2017/2/27 14:39
 */
public class MultiColorRadialGradientView extends View {

    private Paint mPaint;
    private RadialGradient mRadialGradient;
    /**
     * 半径
     */
    private int radius = 100;
    private TileMode mTileMode;

    public MultiColorRadialGradientView(Context context) {
        this(context, null);
    }

    public MultiColorRadialGradientView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiColorRadialGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        /**
         *  View级别的关闭硬件加速
         */
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RadialGradientView);
        String tileMode = typedArray.getString(R.styleable.RadialGradientView_tileMode);
        switch (tileMode) {
            case "CLAMP":
                mTileMode = TileMode.CLAMP;
                break;
            case "MIRROR":
                mTileMode = TileMode.MIRROR;
                break;
            case "REPEAT":
            default:
                mTileMode = TileMode.REPEAT;
                break;
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int[] colors = new int[]{0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00};
        float[] stops = new float[]{0f, 0.2f, 0.5f, 1f};
        mRadialGradient = new RadialGradient(w / 2, h / 2, radius, colors, stops, mTileMode);
//        mRadialGradient = new RadialGradient(w / 2, h / 2, radius, 0xffff0000, 0xff00ff00, TileMode.MIRROR);

        mPaint.setShader(mRadialGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }
}
