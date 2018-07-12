package com.tzl.example.view;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * author: tangzenglei
 * created on: 2018/7/5 下午9:08
 * description: 实现一个随手指移动的view
 * 思路：手指接触控件的时候，手指移动多少距离，左上角跟随移动多少距离
 */
public class DependentView extends AppCompatImageView {

    private float lastX;
    private float lastY;

    public DependentView(Context context) {
        super(context);
    }

    public DependentView(Context context, AttributeSet attrs) {
        super(context
                , attrs);
    }

    public DependentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = 0;
        float y = 0;
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;
        switch (event.getAction()) {

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_MOVE:

                //获取触摸初始位置
                x= event.getRawX();
                y = event.getRawY();

                //获取控件初始位置
                left = getLeft();
                top = getTop();
                right = getRight();
                bottom = getBottom();

                //获取手指移动的距离
                float dx =x - lastX;
                float dy = y - lastY;


                //控件跟随移动
                setLeft((int) (left+dx));
                setTop((int) (top+dy));
                setRight((int) (right+dx));
                setBottom((int) (bottom+dy));



                //TODO:使用简写形式
//                offsetLeftAndRight(dx);
//                offsetTopAndBottom(dy);


                //记录下本次移动的位置
                lastX = x;
                lastY =y;

                break;

        }


        return true;
    }







}
