package com.canplay.milk.mvp.activity.account;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.util.PwdCheckUtil;
import com.canplay.milk.util.TextUtil;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.NavigationBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 修改密码
 */
public class EditorPwsActivity extends BaseActivity {


    @BindView(R.id.navigationbar)
    NavigationBar navigationbar;
    @BindView(R.id.et_pws)
    ClearEditText etPws;
    @BindView(R.id.et_pws1)
    ClearEditText etPws1;
    @BindView(R.id.et_pws2)
    ClearEditText etPws2;
    @BindView(R.id.tv_sure)
    TextView tvSure;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_editor_pass);
        ButterKnife.bind(this);
        navigationbar.setNavigationBarListener(this);


    }

    @Override
    public void bindEvents() {
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtil.isEmpty(etPws.getText().toString())) {
                    showToasts("请填写旧密码");
                }
                if (TextUtil.isEmpty(etPws1.getText().toString())) {
                    showToasts("请填写新密码");
                }
                if (TextUtil.isEmpty(etPws2.getText().toString())) {
                    showToasts("请填写确认密码");
                }
                if (!etPws1.getText().toString().equals(etPws2.getText().toString())) {
                    showToasts("两次密码不一致");
                }
                if (!PwdCheckUtil.isContainAll(etPws1.getText().toString())) {
                    showToasts("密码至少6位数且包含数字，大小写字母");
                    return;
                }


            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
