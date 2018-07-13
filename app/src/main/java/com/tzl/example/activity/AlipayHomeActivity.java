package com.tzl.example.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kyleduo.alipayhome.R;
import com.tzl.example.fragment.MainFragment;

public class AlipayHomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, mainFragment).commitAllowingStateLoss();


    }
}
