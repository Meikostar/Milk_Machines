package com.canplay.milk.mvp.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.NavigationBar;
import com.canplay.milk.view.TimeSelectorDialog;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 修改质料
 */
public class EditorInfoActivity extends BaseActivity {


    @BindView(R.id.line)
    View line;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.et_name)
    ClearEditText etName;
    @BindView(R.id.et_baby)
    ClearEditText etBaby;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    private int sex = 0;
    private String name = "";
    private TimeSelectorDialog selectorDialog;
    private  String time;
    @Override
    public void initViews() {
        setContentView(R.layout.editor_info);
        ButterKnife.bind(this);
        selectorDialog = new TimeSelectorDialog(EditorInfoActivity.this);
        selectorDialog.setDate(new Date(System.currentTimeMillis()))
                .setBindClickListener(new TimeSelectorDialog.BindClickListener() {
                    @Override
                    public void time(String data,int poition,String times) {
                        time=data;
                        tvDate.setText(times);
                    }
                });
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
                finish();
            }

            @Override
            public void navigationimg() {

            }
        });
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectorDialog.show(findViewById(R.id.tv_add));
            }
        });
    }


    public void initData() {

    }


}
