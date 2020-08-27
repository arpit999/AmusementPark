package com.bicubic.amusementpark.model;

import com.bicubic.amusementpark.R;

/**
 * Created by admin on 11-Nov-16.
 */

public enum ViewPagerModel {

    RED(R.string.app_name, R.layout.pager_one),
    BLUE(R.string.app_name, R.layout.pager_two),
    GREEN(R.string.app_name, R.layout.pager_three);

    private int mTitleResId;
    private int mLayoutResId;

    ViewPagerModel(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }



}
