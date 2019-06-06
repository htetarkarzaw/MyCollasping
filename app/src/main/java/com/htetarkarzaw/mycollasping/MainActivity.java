package com.htetarkarzaw.mycollasping;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.SubtitleCollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.6f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;
    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;
    private LinearLayout mTitleContainer;
    private TextView mTitle;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        bindActivity();
//
//        mAppBarLayout.addOnOffsetChangedListener(this);
//        mToolbar.inflateMenu(R.menu.menu_main);
//        startAlphaAnimation(mTitle, 0, View.INVISIBLE);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.z_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SubtitleCollapsingToolbarLayout ctl = findViewById(R.id.subtitlecollapsingtoolbarlayout);
        ctl.setTitle("Best Coupons Deals");
        ctl.setExpandedTitleMargin(16,0,0,0);

        TextView tv =(TextView)findViewById(R.id.coupons_lst);
        tv.setText("ladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfj" +
                "ladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfj" +
                "ladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfj\" +\n" +
                "                \"ladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfj\" +\n" +
                "                \"ladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfj\" +\n" +
                "                \"ladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfj\" +\n" +
                "                \"ladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfjladfj;ajdf;lasjdf;lajflja;lfjasljf;asjf;dfj");
    }

//    private void bindActivity() {
//        mToolbar        = (Toolbar) findViewById(R.id.main_toolbar);
//        mTitle          = (TextView) findViewById(R.id.mainTextViewTitle);
//        mTitleContainer = (LinearLayout) findViewById(R.id.mainLinearTitle);
//        mAppBarLayout   = (AppBarLayout) findViewById(R.id.main_appbar);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.latest_coupons:
//                Toast.makeText(this,"latest coupons action clicked", Toast.LENGTH_LONG).show();
//                return true;
//
//            case R.id.top_stores:
//                Toast.makeText(this,"top stores action clicked", Toast.LENGTH_LONG).show();
//                return true;
//
//            case R.id.action_settings:
//                Toast.makeText(this," action clicked", Toast.LENGTH_LONG).show();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }
//    }
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if(!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }
    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if(mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }
    public static void startAlphaAnimation (View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }
}
