package com.canplay.milk.mvp.activity.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.view.NavigationBar;


import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 奶粉信息
 */
public class MilkDetailActivity extends BaseActivity {


    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tv_weigh)
    TextView tvWeigh;
    @BindView(R.id.tv_ml)
    TextView tvMl;
    @BindView(R.id.tv_wd)
    TextView tvWd;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.tv_change)
    TextView tvChange;

    @Override
    public void initViews() {
        setContentView(R.layout.acitivity_milk_detail);
        ButterKnife.bind(this);
        navigationBar.setNavigationBarListener(this);


//        mWindowAddPhoto = new PhotoPopupWindow(this);
    }

    @Override
    public void bindEvents() {


        tvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public void initData() {

    }





}
