package com.yjn.bottomtabs.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.yjn.bottomtabs.R;
import com.yjn.bottomtabs.intf.BaseViewInterface;
import com.yjn.bottomtabs.widget.BadgeView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements BaseViewInterface, TabHost.OnTabChangeListener, View.OnClickListener {

    @InjectView(android.R.id.tabhost)
    public FragmentTabHost mTabHost;

    public BadgeView mBvNotice; //未读信息条数 , 类似于QQ底部导航的设计

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        initView();
    }

    @Override
    public void initView() {
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        if (android.os.Build.VERSION.SDK_INT > 10) {
            mTabHost.getTabWidget().setShowDividers(0);
        }
        initTabs();

        mTabHost.setCurrentTab(0);
        mTabHost.setOnTabChangedListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 创建底部导航按钮
     */
    private void initTabs() {
        MainTab[] tabs = MainTab.values();
        final int size = tabs.length;
        try {
            for (int i = 0; i < size; i++) {
                MainTab mainTab = tabs[i];
                TabHost.TabSpec tab = mTabHost.newTabSpec(getString(mainTab.getResName()));
                View indicator = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_indicator_badge, null);
                TextView title = (TextView) indicator.findViewById(R.id.tab_title);
                Drawable drawable = this.getResources().getDrawable(mainTab.getResIcon());

                title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);

                if(getString(mainTab.getResName()).equals(getString(R.string.reminder))){

                    View cn = indicator.findViewById(R.id.tab_mes);
                    mBvNotice = new BadgeView(MainActivity.this, cn);
                    mBvNotice.setBadgePosition(BadgeView.POSITION_TOP_LEFT);
                    mBvNotice.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
                    mBvNotice.setBackgroundResource(R.drawable.home_badge_circle_bk);
                    mBvNotice.setGravity(Gravity.CENTER);
                    //mBvNotice.hide(); //隐藏 对应消息组件
                    title.setText(getString(mainTab.getResName()));
                    tab.setIndicator(indicator);
                    tab.setContent(new TabHost.TabContentFactory() {
                        @Override
                        public View createTabContent(String tag) {
                            return new View(MainActivity.this);
                        }
                    });
                    mTabHost.addTab(tab, mainTab.getClz(), null);
                }

                else {
                    title.setText(getString(mainTab.getResName()));
                    tab.setIndicator(indicator);
                    tab.setContent(new TabHost.TabContentFactory() {
                        @Override
                        public View createTabContent(String tag) {
                            return new View(MainActivity.this);
                        }
                    });
                    mTabHost.addTab(tab, mainTab.getClz(), null);
                }
            }
        } catch (Exception e) {
        }
        mTabHost.getTabWidget().setDividerDrawable(android.R.color.transparent);
    }

    /**
     * 底部导航栏切换
     *
     * @param tabId 为 创建 tab 的 resName
     */
    @Override
    public void onTabChanged(String tabId) {

        //这里只是一样demo,具体使用要根据与需求来
        // 只要 tab变化,就展示未读消息
        mBvNotice.setText("8");
        mBvNotice.show();

        final int size = mTabHost.getTabWidget().getTabCount();

        for (int i = 0; i < size; i++) {
            View view = mTabHost.getTabWidget().getChildAt(i);
            if (i == mTabHost.getCurrentTab()) {
                view.setSelected(true);
            } else {
                view.setSelected(false);
            }
        }
    }

}
