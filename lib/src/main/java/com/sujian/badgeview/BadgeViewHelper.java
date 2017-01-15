package com.sujian.badgeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Author sujian
 * Created at 2017/1/14 14:31
 */

public class BadgeViewHelper {



    public enum BadgeGravity {
        RightTop,
        RightCenter,
        RightBottom
    }

    private BadgeInterface mBadgeInterface;
    private Paint mPaint;


    private int mBadgeBgColor;
    private int mBadgeTextColor;
    private int mBadgeTextSize;
    private int mBadgePadding;
    private String mBadgeText;
    private boolean mIsShowBadge;
    private BadgeGravity mBadgeGravity;
    private boolean mIsShowDrawable;
    private Rect mBadgeNumberRect;
    private RectF mBadgeRectF;
    private int mBagdeHorzontalMargin;
    private int mBagdeVerticalMargin;

    public BadgeViewHelper(BadgeInterface badgeInterface, Context context, AttributeSet attributeSet,BadgeGravity badgeGravity) {
        mBadgeInterface = badgeInterface;
        initDefaultAttrs(context,badgeGravity);
        initCustomAttrs(context,attributeSet);
    }

    /**
     * 初始化定制的属性
     * @param context 上下文
     * @param attributeSet 属性集合
     */
    private void initCustomAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArray=context.obtainStyledAttributes(attributeSet,R.styleable.BadgeView);
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            initCustomAttr(typedArray.getIndex(i),typedArray);
        }
        typedArray.recycle();
    }

    /**
     * 得到属性值
     * @param index 索引
     * @param typedArray 属性数组
     */
    private void initCustomAttr(int index, TypedArray typedArray) {

        if (index == R.styleable.BadgeView_badge_bgColor) {
            mBadgeBgColor=typedArray.getColor(index,mBadgeBgColor);
        } else if (index == R.styleable.BadgeView_badge_textColor) {
            mBadgeTextColor=typedArray.getColor(index,mBadgeTextColor);
        } else if (index == R.styleable.BadgeView_badge_textSize) {
            mBadgeTextSize=typedArray.getDimensionPixelSize(index,mBadgeTextSize);
        } else if (index == R.styleable.BadgeView_badge_padding) {
            mBadgePadding=typedArray.getDimensionPixelSize(index,mBadgePadding);
        } else if (index == R.styleable.BadgeView_badge_gravity) {
            // ordinal()方法返回枚举常量的序数(它在枚举声明,其中初始常量分配的零序位)
            int i = typedArray.getInt(index, mBadgeGravity.ordinal());
            mBadgeGravity=BadgeGravity.values()[i];
        }else if (index==R.styleable.BadgeView_badge_horizotalMargin){
            mBagdeHorzontalMargin=typedArray.getDimensionPixelSize(index,mBagdeHorzontalMargin);
        }else if (index==R.styleable.BadgeView_badge_vertiaclMargin){
            mBagdeVerticalMargin=typedArray.getDimensionPixelSize(index,mBagdeVerticalMargin);
        }
        mPaint.setTextSize(mBadgeTextSize);
    }

    /**
     * 初始化默认的属性
     * @param context 上下文
     * @param badgeGravity 徽章显示的位置
     */
    private void initDefaultAttrs(Context context, BadgeGravity badgeGravity) {
        mBadgeBgColor= Color.RED;
        mBadgeTextColor=Color.WHITE;
        mBadgeNumberRect=new Rect();
        mBadgeRectF=new RectF();
        mBadgeTextSize=BadgeViewUtil.sp2px(context,10);
        mBadgePadding=BadgeViewUtil.dp2px(context,4);
        mBagdeHorzontalMargin=BadgeViewUtil.dp2px(context,4);
        mBagdeVerticalMargin=BadgeViewUtil.dp2px(context,4);
        mBadgeGravity=badgeGravity;
        mIsShowBadge=false;
        mBadgeText=null;

        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextAlign(Paint.Align.CENTER);
    }


    public void drawBadge(Canvas canvas) {
        if (mIsShowBadge){
            if (mIsShowDrawable)
            drawDrawableBadge(canvas);
            else
            drawTextBadge(canvas);
        }
    }

    /**
     * 绘制文字徽章
     * @param canvas 画布
     */
    private void drawTextBadge(Canvas canvas) {
        String badgeText="";
        if (!TextUtils.isEmpty(mBadgeText)){
            badgeText=mBadgeText;
        }

        //得到文本宽所占宽高
        mPaint.getTextBounds(badgeText,0,badgeText.length(),mBadgeNumberRect);
        //计算徽章背景的宽高
        int badgeHeight=mBadgeNumberRect.height()+mBadgePadding*2;
        int badgeWidth;
        //当文本长度为1或0时，计算的高度会大于宽度，此时就让宽高相等
        if (badgeText.length()<=1){
            badgeWidth=badgeHeight;
        }else {
            badgeWidth=mBadgeNumberRect.width()+mBadgePadding*2;
        }

        //计算徽章背景上下的值
        mBadgeRectF.top=mBagdeVerticalMargin;
        mBadgeRectF.bottom=mBadgeInterface.getHeight()-mBagdeVerticalMargin;


        switch (mBadgeGravity){
            case RightTop:
                mBadgeRectF.bottom=mBadgeRectF.top+badgeHeight;
                break;
            case RightCenter:
                mBadgeRectF.top=(mBadgeInterface.getHeight()-badgeHeight)/2;
                mBadgeRectF.bottom=mBadgeRectF.top+badgeHeight;
                break;
            case RightBottom:
                mBadgeRectF.top=mBadgeRectF.bottom-badgeHeight;
                break;
        }

        //计算徽章背景左右的值
        mBadgeRectF.right=mBadgeInterface.getWidth()-mBagdeHorzontalMargin;
        mBadgeRectF.left=mBadgeRectF.right-badgeWidth;

        mPaint.setColor(mBadgeBgColor);
        canvas.drawRoundRect(mBadgeRectF,badgeWidth/2,badgeHeight/2,mPaint);

        if (!TextUtils.isEmpty(mBadgeText)){
            mPaint.setColor(mBadgeTextColor);
            float x=mBadgeRectF.left+badgeWidth/2;
            float y=mBadgeRectF.bottom-mBadgePadding;

            canvas.drawText(mBadgeText,x,y,mPaint);
        }
    }

    /**
     * 绘制图像徽章
     * @param canvas 画布
     */
    private void drawDrawableBadge(Canvas canvas) {


    }

    public void showCirclePointBadge() {
        showTextBadge(null);
    }

    public void hideBadge() {
        mIsShowBadge=false;
        mBadgeInterface.postInvalidate();
    }

    public boolean isShow() {
        return mIsShowBadge;
    }

    public void showTextBadge(String text) {
        mIsShowBadge=true;
        mBadgeText=text;
        mBadgeInterface.postInvalidate();
    }
}
