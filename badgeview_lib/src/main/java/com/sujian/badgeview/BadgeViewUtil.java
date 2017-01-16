package com.sujian.badgeview;

import android.content.Context;
import android.util.TypedValue;

/**
 * 工具类
 * Author sujian
 * Created at 2017/1/14 14:42
 */

public class BadgeViewUtil {
    private BadgeViewUtil(){}

    /**
     * dp 转化 px
     * @param context 上下文
     * @param dpValue 默认值
     * @return px
     */
    public static int dp2px(Context context,float dpValue){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dpValue,context.getResources().getDisplayMetrics());
    }

    /**
     * sp 转化 px
     * @param context 上下文
     * @param dpValue 默认值
     * @return px
     */
    public static int sp2px(Context context,float dpValue){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,dpValue,context.getResources().getDisplayMetrics());
    }
}
