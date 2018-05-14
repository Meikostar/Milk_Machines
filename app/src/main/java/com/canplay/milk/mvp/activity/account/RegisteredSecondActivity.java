package com.canplay.milk.mvp.activity.account;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.util.TextUtil;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.NavigationBar;
import com.canplay.milk.view.TimeSelectorDialog;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;

/**
 * 注册2
 */
public class RegisteredSecondActivity extends BaseActivity {


    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.et_name)
    ClearEditText etName;
    @BindView(R.id.tv_choose)
    TextView tvChoose;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.ll_sex)
    LinearLayout llSex;
    @BindView(R.id.et_date)
    ClearEditText etDate;
    @BindView(R.id.et_weight)
    ClearEditText etWeight;
    @BindView(R.id.tv_registered)
    TextView tvRegistered;
    @BindView(R.id.tv_next)
    TextView tvNext;
    private Subscription mSubscription;

    private LinearLayoutManager mLinearLayoutManager;
    private int type;
    private boolean is_time;
    private boolean is_right;

    private String jobId;
    private String name;
    private String date;
    private String psw;

    private TimeSelectorDialog selectorDialog;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_registered2);
        ButterKnife.bind(this);
        navigationBar.setNavigationBarListener(this);
        selectorDialog = new TimeSelectorDialog(RegisteredSecondActivity.this);
        selectorDialog.setDate(new Date(System.currentTimeMillis()))
                .setBindClickListener(new TimeSelectorDialog.BindClickListener() {
                    @Override
                    public void time(String time, int poition, String times) {
                        if (TextUtil.isNotEmpty(time)) {
                            etDate.setText(time);

                        }
                    }


                });

    }

    @Override
    public void bindEvents() {
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyBoard();

            }
        });

        etName.setOnClearEditTextListener(new ClearEditText.ClearEditTextListener() {
            @Override
            public void afterTextChanged4ClearEdit(Editable s) {


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

    }



}
