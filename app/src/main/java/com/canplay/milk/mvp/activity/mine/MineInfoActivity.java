package com.canplay.milk.mvp.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.permission.PermissionConst;
import com.canplay.milk.permission.PermissionSuccess;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.EditorNameDialog;
import com.canplay.milk.view.NavigationBar;
import com.canplay.milk.view.PhotoPopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.valuesfeng.picker.Picker;
import io.valuesfeng.picker.widget.ImageLoaderEngine;


/**
 * 个人信息
 */
public class MineInfoActivity extends BaseActivity {


    @BindView(R.id.line)
    View line;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.iv_imgs)
    ImageView ivImgs;
    @BindView(R.id.et_baby)
    ClearEditText etBaby;
    @BindView(R.id.et_father)
    ClearEditText etFather;
    @BindView(R.id.et_mami)
    ClearEditText etMami;
    private EditorNameDialog dialog;
    private PhotoPopupWindow mWindowAddPhoto;
    private int sex = 0;
    private String name = "";

    @Override
    public void initViews() {
        setContentView(R.layout.activity_mine_info);
        ButterKnife.bind(this);
        navigationBar.setNavigationBarListener(this);

    }

    @Override
    public void bindEvents() {


    }


    public void initData() {

    }

    @PermissionSuccess(requestCode = PermissionConst.REQUECT_CODE_CAMERA)
    public void requestSdcardSuccess() {
        Picker.from(this)
                .count(1)
                .enableCamera(true)
                .setEngine(new ImageLoaderEngine())
                .setAdd_watermark(false)
                .forResult(4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
