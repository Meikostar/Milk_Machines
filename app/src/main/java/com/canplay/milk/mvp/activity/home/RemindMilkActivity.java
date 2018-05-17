package com.canplay.milk.mvp.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.fragment.RemindFragment;
import com.canplay.milk.mvp.adapter.FragmentViewPagerAdapter;
import com.canplay.milk.view.MCheckBox;
import com.canplay.milk.view.NavigationBar;
import com.canplay.milk.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 冲奶提醒
 */
public class RemindMilkActivity extends BaseActivity {


    @BindView(R.id.line)
    View line;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.tv_remind)
    TextView tvRemind;
    @BindView(R.id.viewpager_main)
    NoScrollViewPager viewpagerMain;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.iv_choose)
    MCheckBox ivChoose;
    private int type;
    private FragmentViewPagerAdapter mainViewPagerAdapter;
    private List<Fragment> mFragments;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_remind_health);
        ButterKnife.bind(this);
        navigationBar.setNavigationBarListener(this);
        type = getIntent().getIntExtra("type", 0);
        if (type != 0) {
            tvAdd.setVisibility(View.VISIBLE);
        }

    }


    private int status;

    @Override
    public void bindEvents() {


        navigationBar.setNavigationBarListener(new NavigationBar.NavigationBarListener() {
            @Override
            public void navigationLeft() {
                finish();
            }

            @Override
            public void navigationRight() {


            }

            @Override
            public void navigationimg() {

            }
        });
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(RemindMilkActivity.this,RemindSettingActivity.class));

            }
        });

    }


    @Override
    public void initData() {
        addFragment();
        mainViewPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), mFragments);
        viewpagerMain.setAdapter(mainViewPagerAdapter);
        viewpagerMain.setOffscreenPageLimit(2);//设置缓存view 的个数
        viewpagerMain.setCurrentItem(0);
        viewpagerMain.setScanScroll(false);
    }


    private RemindFragment measureRemindFragment;

    private void addFragment() {
        mFragments = new ArrayList<>();

        measureRemindFragment = new RemindFragment();

        mFragments.add(measureRemindFragment);

    }


}
