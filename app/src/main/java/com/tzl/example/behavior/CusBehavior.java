package com.tzl.example.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.kyleduo.alipayhome.R;

/**
 * author: tangzenglei
 * created on: 2018/7/6 上午11:34
 * description: 跟屁虫 Behavior
 */
public class CusBehavior extends CoordinatorLayout.Behavior {


    /**
     * CoordinaLayout 通过反射获取对象
     * @param context
     * @param attrs
     */
    public CusBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //校验 dependency 依赖者的身份
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency.getId() == R.id.dependency;
    }


    /**
     * dependency view 发生改变时，child 如何应对？
     *
     * childView 发生变化时，dependency 通过 NestedScrolling 机制改变
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        //使依赖的 view 在被依赖 view 的右侧
        child.setX(dependency.getX() + dependency.getWidth());
        child.setY(dependency.getY());
        return true;
    }
}
