package com.yjn.bottomtabs.ui;

import com.yjn.bottomtabs.R;
import com.yjn.bottomtabs.fragment.BillFragment;
import com.yjn.bottomtabs.fragment.BundleFragment;
import com.yjn.bottomtabs.fragment.HomeFragment;
import com.yjn.bottomtabs.fragment.ReminderFragment;

public enum MainTab {

    HOME(0, R.string.home, R.drawable.main_tab_icon_home, HomeFragment.class),

    BUNDLES(1, R.string.bundles, R.drawable.main_tab_icon_boundles, BundleFragment.class),

    BILL(2, R.string.bill, R.drawable.main_tab_icon_bill, BillFragment.class),

    REMINDER(3, R.string.reminder, R.drawable.main_tab_icon_reminder, ReminderFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}
