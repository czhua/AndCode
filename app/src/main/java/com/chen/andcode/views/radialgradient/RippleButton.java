package com.chen.andcode.views.radialgradient;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

import com.chen.andcode.R;


/**
 * 波纹Button
 */
public class RippleButton extends Button {

    private Paint mPaint;
    private int mX, mY;
    private ObjectAnimator mAnimator;
    private int DEFAULT_RADIUS = 50;
    private int mCurRadius = 0;
    private RadialGradient mRadialGradient;

    public RippleButton(Context context) {
        this(context, null);
    }

    public RippleButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RippleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        /**
         *  View级别的关闭硬件加速
         */
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mX != event.getX() || mY != mY) {
            mX = (int) event.getX();
            mY = (int) event.getY();
            setRadius(DEFAULT_RADIUS);
        }

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if (mAnimator != null && mAnimator.isRunning()) {
                mAnimator.cancel();
            }

            if (mAnimator == null) {
                mAnimator = ObjectAnimator.ofInt(this, "radius", DEFAULT_RADIUS, getWidth());
            }

            mAnimator.setInterpolator(new AccelerateInterpolator());
            mAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    setRadius(0);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            mAnimator.start();
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mX, mY, mCurRadius, mPaint);
    }

    public void setRadius(int radius) {
        mCurRadius = radius;
        if (mCurRadius > 0) {
            mRadialGradient = new RadialGradient(mX, mY, mCurRadius, 0x00FFFFFF, 0xFF58FAAC, TileMode.CLAMP);
            mPaint.setShader(mRadialGradient);
        }
        postInvalidate();
    }
}
