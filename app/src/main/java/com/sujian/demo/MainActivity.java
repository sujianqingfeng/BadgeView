package com.sujian.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sujian.badgeview.BadgeView;


/**
 * Author sujian
 * Create at 2017/1/14 13:54
 */
public class MainActivity extends AppCompatActivity {

    private BadgeView mBadgeView;
    private BadgeView mBadgeView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBadgeView= (BadgeView) findViewById(R.id.badgeview);
        mBadgeView.showCirclePointBadge();

        mBadgeView1= (BadgeView) findViewById(R.id.badgeview1);
        mBadgeView1.showTextBadge("9");
    }
}
