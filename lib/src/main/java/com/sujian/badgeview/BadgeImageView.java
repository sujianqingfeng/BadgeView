package com.sujian.badgeview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Author sujian
 * Created at 2017/1/15 13:19
 */

public class BadgeImageView extends ImageView implements BadgeInterface {

    private BadgeViewHelper mBadgeViewHelper;
    public BadgeImageView(Context context) {
        this(context,null);
    }

    public BadgeImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BadgeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
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
