package com.tzl.example.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.kyleduo.alipayhome.R;
import com.tzl.example.utils.BottomNavigationHelper;

/**
 * 参考自：https://juejin.im/post/59f924b0f265da431f4a60c3
 */
public class BottomNavigationViewActivity extends AppCompatActivity {

    private BottomNavigationView bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);
        bottom = (BottomNavigationView) findViewById(R.id.bottomNavigatingView);
        BottomNavigationHelper.disableShiftMode(bottom);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.menu_camera:

                        Toast.makeText(BottomNavigationViewActivity.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_palette:

                        Toast.makeText(BottomNavigationViewActivity.this, "2", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.menu_security:
                        Toast.makeText(BottomNavigationViewActivity.this, "3", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.menu_setting:

                        Toast.makeText(BottomNavigationViewActivity.this, "4", Toast.LENGTH_SHORT).show();
                        break;
                }


                //true 播放切换动画
                return true;


            }
        });



        //TODO:避免重复点击


    }
}
