package com.sujian.badgeview;

import android.content.Context;

/**
 * Author sujian
 * Created at 2017/1/14 14:28
 */

public interface BadgeInterface {

    void showCirclePointBadge();

    void showTextBadge(String text);

    void hideBadge();

    boolean isShow();

    void postInvalidate();

    int getHeight();

    int getWidth();

    Context getContext();

    BadgeViewHelper getBadgeViewHelper();

}
