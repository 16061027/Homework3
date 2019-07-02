package com.example.chapter3.homework;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ch3Ex3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);



        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面
        ViewPager pager = findViewById(R.id.view_pagers);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return new BlankFragment();
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                if(position == 0)
                    return "好友列表";
                else
                    return "我的好友";
            }
        });


        // TODO: ex3-2, 添加 TabLayout 支持 Tab

        tabLayout.setupWithViewPager(pager);


    }
}
