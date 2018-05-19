package com.canplay.milk.mvp.activity.account;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.base.BaseApplication;
import com.canplay.milk.base.RxBus;
import com.canplay.milk.base.SubscriptionBean;
import com.canplay.milk.bean.RecoveryPsw;
import com.canplay.milk.mvp.component.DaggerBaseComponent;
import com.canplay.milk.mvp.present.LoginContract;
import com.canplay.milk.mvp.present.LoginPresenter;
import com.canplay.milk.util.PwdCheckUtil;
import com.canplay.milk.util.TextUtil;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.NavigationBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 忘记密码
 */

public class ForgetPswActivity extends BaseActivity implements LoginContract.View{

    @Inject
    LoginPresenter presenter;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.et_phone)
    ClearEditText etPhone;
    @BindView(R.id.tv_getcode)
    TextView tvGetcode;
    @BindView(R.id.et_pass)
    ClearEditText etPass;
    @BindView(R.id.iv_check1)
    ImageView ivCheck1;
    @BindView(R.id.et_user)
    ClearEditText etUser;
    @BindView(R.id.iv_check2)
    ImageView ivCheck2;
    @BindView(R.id.et_confirm)
    ClearEditText etConfirm;
    @BindView(R.id.iv_check3)
    ImageView ivCheck3;
    @BindView(R.id.tv_hint)
    TextView tvHint;
    @BindView(R.id.tv_next)
    TextView tvNext;

    private TimeCount timeCount;
    @Override
    public void initViews() {
        setContentView(R.layout.activity_forget_psw);
        ButterKnife.bind(this);
        DaggerBaseComponent.builder().appComponent(((BaseApplication) getApplication()).getAppComponent()).build().inject(this);
        presenter.attachView(this);
        timeCount = new TimeCount(60000, 1000);
    }


    @Override
    public void bindEvents() {
          tvGetcode.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  String user = etPhone.getText().toString();
                  if (TextUtil.isEmpty(user)) {
                      showToasts(getString(R.string.qingshurusjh));
                      return;
                  }
                  presenter.getForgetPswCode(user);
              }
          });
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtil.isEmpty(etUser.getText().toString())){
                    showToasts("请输入验证码");
                    return;
                }  if(TextUtil.isEmpty(etPass.getText().toString())){
                    showToasts("请输入密码");
                    return;
                }  if(TextUtil.isEmpty(etConfirm.getText().toString())){
                    showToasts("请再次输入密码");
                    return;
                }
                if(!etPass.getText().toString().equals(etConfirm.getText().toString())){
                    showToasts("两次密码不一致");
                    return;
                }
                if(!PwdCheckUtil.isLetterDigit(etPass.getText().toString())){
                    showToasts("密码至少6位数且包含数字，字母");
                    return;
                }
                presenter.resetPwd(etPhone.getText().toString(),etUser.getText().toString(),etPass.getText().toString());
            }
        });
        etPhone.setOnClearEditTextListener(new ClearEditText.ClearEditTextListener() {
            @Override
            public void afterTextChanged4ClearEdit(Editable s) {
                if (s.toString().length() < 11) {
                    etUser.setText("");
                    tvGetcode.setText(R.string.chongxinhuoqu);
                    tvGetcode.setBackground(getResources().getDrawable(R.drawable.login_selector));
                    tvGetcode.setEnabled(true);
                }
            }

            @Override
            public void changeText(CharSequence s) {

            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
     if(timeCount!=null){
         timeCount.cancel();
     }
    }

    public void isSelect(boolean choose) {
        if (choose) {

//            tvLogin.setBackground(getResources().getDrawable(R.drawable.login_selector));
        } else {

        }

    }



    @Override
    public <T> void toEntity(T entity, int type) {
      if(type==1){
          timeCount.start();
      }else {
          RxBus.getInstance().send(SubscriptionBean.createSendBean(SubscriptionBean.FINISH,""));

          startActivity(new Intent(ForgetPswActivity.this,LoginActivity.class));
          finish();
          showToasts("密码修改成功");
      }

    }

    @Override
    public void showTomast(String msg) {

    }


    //计时器
    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tvGetcode.setEnabled(false);
            tvGetcode.setText(millisUntilFinished / 1000 + getString(R.string.schongxinhuoqu));
        }

        @Override
        public void onFinish() {

            tvGetcode.setText(R.string.chongxinhuoqu);
            tvGetcode.setBackground(getResources().getDrawable(R.drawable.login_selector));
            tvGetcode.setEnabled(true);
        }
    }

}
