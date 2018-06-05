package com.canplay.milk.mvp.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.base.BaseApplication;
import com.canplay.milk.bean.SetMilk;
import com.canplay.milk.mvp.component.DaggerBaseComponent;
import com.canplay.milk.mvp.present.BaseContract;
import com.canplay.milk.mvp.present.BasesPresenter;
import com.canplay.milk.util.SpUtil;
import com.canplay.milk.view.NavigationBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 一键冲奶
 */
public class PushMilkActivity extends BaseActivity implements BaseContract.View {

    @Inject
    BasesPresenter presenter;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tv_ml)
    TextView tvMl;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_mls)
    TextView tvMls;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.tv_begin)
    TextView tvBegin;
    @BindView(R.id.tv_wd)
    TextView tvWd;

    @Override
    public void initViews() {
        setContentView(R.layout.acitivity_push_milk);
        ButterKnife.bind(this);
        DaggerBaseComponent.builder().appComponent(((BaseApplication) getApplication()).getAppComponent()).build().inject(this);
        presenter.attachView(this);
        SetMilk milk = SpUtil.getInstance().getMilk();
        if(milk!=null){
            tvState.setText(milk.consistence.equals("high")?"高":(milk.consistence.equals("middle")?"中":"低"));
            tvMls.setText(milk.waterQuantity);
            tvWd.setText(milk.waterTemperature);
        }

//        mWindowAddPhoto = new PhotoPopupWindow(this);
    }

    @Override
    public void bindEvents() {
        navigationBar.setNavigationBarListener(new NavigationBar.NavigationBarListener() {
            @Override
            public void navigationLeft() {
                finish();
            }

            @Override
            public void navigationRight() {
                startActivity(new Intent(PushMilkActivity.this, AddMilkActivity.class));
            }

            @Override
            public void navigationimg() {

            }
        });

        tvBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.insertUserMilkRecord(tvMl.getText().toString());
            }
        });
    }


    @Override
    public void initData() {

    }


    @Override
    public <T> void toEntity(T entity, int type) {
        showToasts("冲奶成功");
        finish();
    }

    @Override
    public void toNextStep(int type) {

    }

    @Override
    public void showTomast(String msg) {
        showToasts(msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
