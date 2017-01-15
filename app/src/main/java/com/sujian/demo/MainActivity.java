package com.sujian.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sujian.badgeview.BadgeImageView;
import com.sujian.badgeview.BadgeRadioButton;
import com.sujian.badgeview.BadgeView;


/**
 * Author sujian
 * Create at 2017/1/14 13:54
 */
public class MainActivity extends AppCompatActivity {

    private BadgeView mBadgeView;
    private BadgeView mBadgeView1;

    private BadgeImageView badge_ImageView;
    private BadgeImageView badge_ImageView1;
    private BadgeRadioButton mBadgeRadioButton,mBadgeRadioButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBadgeView= (BadgeView) findViewById(R.id.badgeview);
        mBadgeView.showCirclePointBadge();

        mBadgeView1= (BadgeView) findViewById(R.id.badgeview1);
        mBadgeView1.showTextBadge("9");

        badge_ImageView= (BadgeImageView) findViewById(R.id.badge_ImageView);
        badge_ImageView1= (BadgeImageView) findViewById(R.id.badge_ImageView1);


        badge_ImageView.showCirclePointBadge();
        badge_ImageView1.showTextBadge("5");

        mBadgeRadioButton= (BadgeRadioButton) findViewById(R.id.radio);
        mBadgeRadioButton1= (BadgeRadioButton) findViewById(R.id.radio1);

        mBadgeRadioButton.showCirclePointBadge();
        mBadgeRadioButton1.showTextBadge("7");

    }
}
