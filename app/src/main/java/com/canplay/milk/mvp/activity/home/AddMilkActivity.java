package com.canplay.milk.mvp.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.base.BaseApplication;
import com.canplay.milk.base.RxBus;
import com.canplay.milk.base.SubscriptionBean;
import com.canplay.milk.bean.SetMilk;
import com.canplay.milk.mvp.component.DaggerBaseComponent;
import com.canplay.milk.mvp.present.BaseContract;
import com.canplay.milk.mvp.present.BasesPresenter;
import com.canplay.milk.util.SpUtil;
import com.canplay.milk.view.BaseSelector;
import com.canplay.milk.view.HintDialogone;
import com.canplay.milk.view.NavigationBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 冲奶设置
 */
public class AddMilkActivity extends BaseActivity implements BaseContract.View {

    @Inject
    BasesPresenter presenter;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.tv_equptname)
    TextView tvEquptname;
    @BindView(R.id.tv_milk)
    TextView tvMilk;
    @BindView(R.id.bs_ml)
    BaseSelector bsMl;
    @BindView(R.id.bs_wd)
    BaseSelector bsWd;
    @BindView(R.id.bs_nd)
    BaseSelector bsNd;
    private HintDialogone dialogone;

    @Override
    public void initViews() {
        setContentView(R.layout.acitivity_add_milk);
        ButterKnife.bind(this);
        DaggerBaseComponent.builder().appComponent(((BaseApplication) getApplication()).getAppComponent()).build().inject(this);
        presenter.attachView(this);
        dialogone = new HintDialogone(this, 2);

    }

    private SetMilk milk = new SetMilk();

    @Override
    public void bindEvents() {
        dialogone.setBindClickListener(new HintDialogone.BindClickListener() {
            @Override
            public void clicks(int type, int right) {
                finish();
            }
        });
        navigationBar.setNavigationBarListener(new NavigationBar.NavigationBarListener() {
            @Override
            public void navigationLeft() {
                finish();
            }

            @Override
            public void navigationRight() {
                milk.waterQuantity = bsMl.getSelector();
                milk.consistence = bsNd.getSelector().equals("高") ? "high" : (bsNd.getSelector().equals("中") ? "middle" : "low");
                milk.waterTemperature = bsWd.getSelector();
                showProgress("保存中...");
                presenter.setUserMilkConf(milk.consistence, milk.waterQuantity, milk.waterTemperature);

            }

            @Override
            public void navigationimg() {

            }
        });


        tvMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddMilkActivity.this, PushMilkActivity.class));
                finish();
            }
        });
    }


    @Override
    public void initData() {
        SetMilk milk = SpUtil.getInstance().getMilk();
        bsMl.setData(2,milk.waterQuantity);
        bsNd.setData(1,milk.consistence);
        bsNd.setData(0,milk.waterTemperature);
    }


    @Override
    public <T> void toEntity(T entity, int type) {
        dimessProgress();
        RxBus.getInstance().send(SubscriptionBean.createSendBean(SubscriptionBean.REFEST_SET,""));
        dialogone.show(findViewById(R.id.line));
    }

    @Override
    public void toNextStep(int type) {

    }

    @Override
    public void showTomast(String msg) {
        dimessProgress();
        showToasts(msg);
    }
}
