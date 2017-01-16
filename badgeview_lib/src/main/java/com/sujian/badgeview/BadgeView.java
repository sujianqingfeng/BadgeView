package com.sujian.badgeview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author sujian
 * Created at 2017/1/14 14:25
 */

public class BadgeView extends View implements BadgeInterface{

    private BadgeViewHelper mBadgeViewHelper;

    public BadgeView(Context context) {
        this(context,null);
    }

    public BadgeView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBadgeViewHelper=new BadgeViewHelper(this,context,attrs, BadgeViewHelper.BadgeGravity.RightTop);
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
}
