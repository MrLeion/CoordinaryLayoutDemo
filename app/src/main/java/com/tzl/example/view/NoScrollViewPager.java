package com.tzl.example.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * author: tangzenglei
 * created on: 2018/7/12 下午1:45
 * description: 禁止滚动 ViewPager
 */
public class NoScrollViewPager extends ViewPager{

    private boolean isScollEnabled = false;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isScollEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isScollEnabled && super.onInterceptTouchEvent(event);
    }

    @Override public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

}
