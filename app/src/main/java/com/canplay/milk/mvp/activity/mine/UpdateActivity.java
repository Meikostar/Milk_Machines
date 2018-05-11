package com.canplay.milk.mvp.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.view.NavigationBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 检查更新
 */
public class UpdateActivity extends BaseActivity {


    @BindView(R.id.line)
    View line;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_update);
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
