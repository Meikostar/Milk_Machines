package com.canplay.milk.mvp.activity.account;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.bean.RecoveryPsw;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.NavigationBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 忘记密码
 */

public class ForgetPswActivity extends BaseActivity {


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
    private int type;
    private String username;
    private String passwordResetToken;

    private boolean is_time;
    private RecoveryPsw recoveryPsw;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_forget_psw);
        ButterKnife.bind(this);
        type = getIntent().getIntExtra("type", 0);
        passwordResetToken = getIntent().getStringExtra("passwordResetToken");
        username = getIntent().getStringExtra("username");
        recoveryPsw = new RecoveryPsw();
        recoveryPsw.passwordResetToken = passwordResetToken;
        recoveryPsw.username = username;

    }


    @Override
    public void bindEvents() {

//        etNpws.setOnClearEditTextListener(new ClearEditText.ClearEditTextListener() {
//            @Override
//            public void afterTextChanged4ClearEdit(Editable s) {
//                if (TextUtil.isNotEmpty(s.toString())) {
//                    if (b == 0) {
//                        ++count;
//                        b = 1;
//                    }
//                } else {
//                    --count;
//                    b = 0;
//                }
//                if (count == 2) {
//                    isSelect(true);
//                } else {
//                    isSelect(false);
//                }
//            }
//
//            @Override
//            public void changeText(CharSequence s) {
//
//            }
//        });
//
//        etPws.setOnClearEditTextListener(new ClearEditText.ClearEditTextListener() {
//            @Override
//            public void afterTextChanged4ClearEdit(Editable s) {
//                if (TextUtil.isNotEmpty(s.toString())) {
//                    if (d == 0) {
//                        ++count;
//                        d = 1;
//                    }
//                } else {
//                    --count;
//                    d = 0;
//                }
//                if (count == 4) {
//                    isSelect(true);
//                } else {
//                    isSelect(false);
//                }
//            }
//
//            @Override
//            public void changeText(CharSequence s) {
//
//            }
//        });
//        ivBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//        tvLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!PwdCheckUtil.isContainAll(etPws.getText().toString()) || etPws.getText().toString().length() < 6) {
//                    showToasts("密码至少6位数且包含数字，大小写字母");
//                    return;
//                }
//                if (!etPws.getText().toString().equals(etNpws.getText().toString())) {
//                    showToasts("两次密码输入不一致");
//                    return;
//                }
//                recoveryPsw.newPassword = etPws.getText().toString();
//
//            }
//        });

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void isSelect(boolean choose) {
        if (choose) {

//            tvLogin.setBackground(getResources().getDrawable(R.drawable.login_selector));
        } else {

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
