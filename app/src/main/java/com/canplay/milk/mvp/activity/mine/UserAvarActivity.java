package com.canplay.milk.mvp.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.view.NavigationBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 用户头像
 */
public class UserAvarActivity extends BaseActivity {


    @BindView(R.id.line)
    View line;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.tv_choose)
    TextView tvChoose;
    @BindView(R.id.tv_local)
    TextView tvLocal;
    @BindView(R.id.iv_img)
    ImageView ivImg;

    @Override
    public void initViews() {
        setContentView(R.layout.acitvity_avator);
        ButterKnife.bind(this);
        navigationBar.setNavigationBarListener(this);


//        mWindowAddPhoto = new PhotoPopupWindow(this);
    }

    @Override
    public void bindEvents() {


    }


    @Override
    public void initData() {

    }

}
