package com.tzl.example.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.kyleduo.alipayhome.R;

import java.util.ArrayList;
import java.util.List;

public class ZhihuActivity extends AppCompatActivity {


    List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihu);

        setUpView();
        initView();
    }

    private void setUpView() {


    }

    private void initView() {



    }


}
