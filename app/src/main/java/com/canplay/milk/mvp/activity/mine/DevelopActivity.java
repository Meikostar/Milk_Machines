package com.canplay.milk.mvp.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.fragment.DataFragment;
import com.canplay.milk.mvp.adapter.FragmentViewPagerAdapter;
import com.canplay.milk.view.NavigationBar;
import com.canplay.milk.view.NoScrollViewPager;
import com.canplay.milk.view.OnChangeListener;
import com.canplay.milk.view.ThreeNevgBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 发育评估
 */
public class DevelopActivity extends BaseActivity {


    @BindView(R.id.line)
    View line;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.tv_data)
    TextView tvData;
    @BindView(R.id.viewpager_main)
    NoScrollViewPager viewpagerMain;
    @BindView(R.id.ne_bar)
    ThreeNevgBar neBar;
    private FragmentViewPagerAdapter mainViewPagerAdapter;
    private List<Fragment> mFragments;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_develop);
        ButterKnife.bind(this);
        navigationBar.setNavigationBarListener(this);


    }


    @Override
    public void bindEvents() {
        neBar.setOnChangeListener(new OnChangeListener() {
            @Override
            public void onChagne(int currentIndex) {
                viewpagerMain.setCurrentItem(currentIndex);
            }
        });




    }


    @Override
    public void initData() {
        addFragment();
        mainViewPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), mFragments);
        viewpagerMain.setAdapter(mainViewPagerAdapter);
        viewpagerMain.setOffscreenPageLimit(3);//设置缓存view 的个数
        viewpagerMain.setCurrentItem(0);

        viewpagerMain.setScanScroll(false);

    }

    private DataFragment oneFragment;
    private DataFragment twoFragment;
    private DataFragment threetFragment;

    private void addFragment() {
        mFragments = new ArrayList<>();
        oneFragment = new DataFragment(1);
        twoFragment = new DataFragment(2);
        threetFragment = new DataFragment(3);

        mFragments.add(oneFragment);
        mFragments.add(twoFragment);
        mFragments.add(threetFragment);

    }



}
