package com.canplay.milk.mvp.activity.account;

import android.Manifest;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.base.BaseApplication;
import com.canplay.milk.bean.USER;
import com.canplay.milk.mvp.activity.MainActivity;
import com.canplay.milk.mvp.component.DaggerBaseComponent;
import com.canplay.milk.mvp.present.LoginContract;
import com.canplay.milk.mvp.present.LoginPresenter;
import com.canplay.milk.permission.PermissionConst;
import com.canplay.milk.permission.PermissionFail;
import com.canplay.milk.permission.PermissionGen;
import com.canplay.milk.permission.PermissionSuccess;

import com.canplay.milk.util.SpUtil;
import com.canplay.milk.util.TextUtil;
import com.canplay.milk.view.ClearEditText;
import com.google.zxing.client.android.activity.CaptureActivity;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends BaseActivity implements LoginContract.View{

    @Inject
    LoginPresenter presenter;
    @BindView(R.id.tv_logo)
    ImageView tvLogo;
    @BindView(R.id.et_user)
    ClearEditText etUser;
    @BindView(R.id.et_pws)
    ClearEditText etPws;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    @BindView(R.id.tv_registered)
    TextView tvRegistered;


    @Override
    public void initViews() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        DaggerBaseComponent.builder().appComponent(((BaseApplication) getApplication()).getAppComponent()).build().inject(this);
        presenter.attachView(this);


        String userId = SpUtil.getInstance().getUserId();
        if (TextUtil.isNotEmpty(userId)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @PermissionSuccess(requestCode = PermissionConst.REQUECT_DATE)
    public void requestSdcardSuccess() {
        Intent intent = new Intent(LoginActivity.this, CaptureActivity.class);
         /*ZxingConfig是配置类  可以设置是否显示底部布局，闪光灯，相册，是否播放提示音  震动等动能
         * 也可以不传这个参数
         * 不传的话  默认都为默认不震动  其他都为true
         * */

        //ZxingConfig config = new ZxingConfig();
        //config.setShowbottomLayout(true);//底部布局（包括闪光灯和相册）
        //config.setPlayBeep(true);//是否播放提示音
        //config.setShake(true);//是否震动
        //config.setShowAlbum(true);//是否显示相册
        //config.setShowFlashLight(true);//是否显示闪光灯
        //intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    @PermissionFail(requestCode = PermissionConst.REQUECT_DATE)
    public void requestSdcardFailed() {
        showToasts("获取权限失败");
    }

    private int REQUEST_CODE_SCAN =6;
    @Override
    public void bindEvents() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                PermissionGen.with(LoginActivity.this)
                        .addRequestCode(PermissionConst.REQUECT_DATE)
                        .permissions(
                                Manifest.permission.CAMERA,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE)
                        .request();
                String user = etUser.getText().toString();
                String password = etPws.getText().toString();

                if (TextUtil.isEmpty(user)) {
                    showToasts(getString(R.string.qingshurusjh));
                    return;
                }
                if (TextUtil.isEmpty(password)) {
                    showToasts(getString(R.string.mimanull));
                    return;
                }
                presenter.goLogin(user,password);
                showProgress("登录中...");
            }
        });


        tvForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//忘记密码
                Intent intent=new Intent(LoginActivity.this,ForgetFirstActivity.class);
                startActivity(intent);
            }
        });

        tvRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//注册
                Intent intent=new Intent(LoginActivity.this,RegisteredActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {

    }

   private USER user;
    @Override
    public <T> void toEntity(T entity, int type) {
       dimessProgress();
        user= (USER) entity;
        SpUtil.getInstance().putUser(user);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void showTomast(String msg) {

    }
}
