package com.sujian.badgeview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RadioButton;

/**
 * Author sujian
 * Created at 2017/1/15 13:32
 */

public class BadgeRadioButton extends RadioButton implements BadgeInterface {

    private BadgeViewHelper mBadgeViewHelper;

    public BadgeRadioButton(Context context) {
        this(context,null);
    }

    public BadgeRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BadgeRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setClickable(true);
        mBadgeViewHelper=new BadgeViewHelper(this,context,attrs, BadgeViewHelper.BadgeGravity.RightTop);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mBadgeViewHelper.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mBadgeViewHelper.drawBadge(canvas);
    }

    @Override
    public void showCirclePointBadge() {
        mBadgeViewHelper.showCirclePointBadge();
    }

    @Override
    public void showTextBadge(String text) {
        mBadgeViewHelper.showTextBadge(text);
    }

    @Override
    public void hideBadge() {
mBadgeViewHelper.hideBadge();
    }

    @Override
    public boolean isShow() {
        return mBadgeViewHelper.isShow();
    }

    @Override
    public BadgeViewHelper getBadgeViewHelper() {
        return mBadgeViewHelper;
    }

    @Override
    public boolean superOnTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
