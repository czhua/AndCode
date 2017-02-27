package com.chen.andcode.anim;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatButton;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chen.andcode.R;
import com.chen.andcode.base.BaseActivity;
import com.github.florent37.expectanim.ExpectAnim;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.github.florent37.expectanim.core.Expectations.alphaValue;
import static com.github.florent37.expectanim.core.Expectations.height;
import static com.github.florent37.expectanim.core.Expectations.leftOfParent;
import static com.github.florent37.expectanim.core.Expectations.rightOfParent;
import static com.github.florent37.expectanim.core.Expectations.sameCenterVerticalAs;
import static com.github.florent37.expectanim.core.Expectations.scale;
import static com.github.florent37.expectanim.core.Expectations.toRightOf;
import static com.github.florent37.expectanim.core.Expectations.topOfParent;


/**
 * @author zehua_chen
 *         create at 2017/2/27 14:54
 */
public class AnimActivity extends BaseActivity {


    @BindView(R.id.scorllview)
    NestedScrollView mScorllview;
    @BindView(R.id.background_v)
    View bgView;
    @BindView(R.id.avatar_iv)
    CircleImageView avatarIv;
    @BindView(R.id.username_tv)
    TextView usernameTv;
    @BindView(R.id.follow_btn)
    AppCompatButton followBtn;
    @BindView(R.id.cv1)
    View mCardView;

    @BindDimen(R.dimen.height)
    int height;

    private ExpectAnim expectAnim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        ButterKnife.bind(this);

        this.expectAnim = new ExpectAnim()
                .expect(avatarIv)
                .toBe(
                        topOfParent().withMarginDp(0),
                        leftOfParent().withMarginDp(20),
                        scale(0.5f, 0.5f)
                )
                .expect(usernameTv)
                .toBe(
                        toRightOf(avatarIv).withMarginDp(16),
                        sameCenterVerticalAs(avatarIv),
                        alphaValue(0.5f)
                )
                .expect(followBtn)
                .toBe(
                        rightOfParent().withMarginDp(20),
                        sameCenterVerticalAs(avatarIv)
                )
                .expect(bgView)
                .toBe(
                        height(height).withGravity(Gravity.LEFT, Gravity.TOP)
                )
                .toAnimation();

        mScorllview.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                final float percent = (scrollY * 1f) / v.getMaxScrollAmount();
                expectAnim.setPercent(percent);
            }
        });

        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimActivity.this, RadialGradientActivity.class);
                startActivity(intent);
            }
        });
    }
}
