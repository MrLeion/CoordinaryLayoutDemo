package com.tzl.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kyleduo.alipayhome.R;


/**
 * CoordinaLayout 学习
 */
public class FunctionListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_list);
    }


    public void jump2FloatingButton(View view) {
        startActivity(new Intent(this,FloatingButtonActivity.class));
    }


    public void jump2AppBarLayout(View view) {
        startActivity(new Intent(this,AppBarLayoutActivity.class));
    }

    public void jump2CollapsingLayout(View view) {
        startActivity(new Intent(this, CollapsingToolbarLayoutActivity.class));
    }


    public void jump2CustomeBehavior(View view) {
        startActivity(new Intent(this, CustomeBehaviorActivity.class));
    }

    public void jump2NestedScrolling(View view) {
        startActivity(new Intent(this, NestedScrollingActivity.class));
    }

    public void jump2Uc(View view) {
        startActivity(new Intent(this, UcActivity.class));
    }


    public void jump2Zhihu(View view) {
        startActivity(new Intent(this, ZhihuActivity.class));
    }



    public void jump2Weibo(View view) {
        startActivity(new Intent(this,WeiboActivity.class));
    }


    public void jump2AlipayHome(View view) {
        startActivity(new Intent(this,AlipayHomeActivity.class));
    }

}
