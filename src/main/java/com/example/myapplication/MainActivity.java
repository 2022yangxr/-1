package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager2)
    ViewPager2 viewPager2;

    List<Fragment> fragmentList = new ArrayList<>();
    MyFragmentStateAdapter adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BindView
        ButterKnife.bind(this);
        //初始化
        init();
    }

    private void init() {

        //切换方向
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        //添加fragment
        for (int i = 1; i <=3; i++) {
            fragmentList.add(MyFragment.newInstance("第" + i+"页"));
        }

        //设置适配器
        adapter = new MyFragmentStateAdapter(getSupportFragmentManager(), this.getLifecycle(), fragmentList);
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText("页面" + (position+1));
            }
        }).attach();
    }
}
