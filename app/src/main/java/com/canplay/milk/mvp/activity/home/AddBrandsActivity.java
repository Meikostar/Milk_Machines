package com.canplay.milk.mvp.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.bean.DATA;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.ListPopupWindow;
import com.canplay.milk.view.NavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 新增品牌
 */
public class AddBrandsActivity extends BaseActivity {


    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.et_brand)
    ClearEditText etBrand;
    @BindView(R.id.tv_choose)
    TextView tvChoose;
    @BindView(R.id.et_ml)
    ClearEditText etMl;
    @BindView(R.id.et_wd)
    ClearEditText etWd;
    @BindView(R.id.et_weight)
    ClearEditText etWeight;
    @BindView(R.id.ll_choose)
    LinearLayout llChoose;
    @BindView(R.id.line)
    View line;
    private ListPopupWindow popupWindow;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_add_brand);
        ButterKnife.bind(this);

    }

    @Override
    public void bindEvents() {
        llChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAsDropDown(line);
            }
        });
    }
            private List<DATA> data = new ArrayList<>();

            @Override
            public void initData() {
                DATA datas = new DATA();
                datas.content = "一段";
                DATA data1 = new DATA();
                data1.content = "二段";
                DATA data2 = new DATA();
                data2.content = "三段";
                DATA data3 = new DATA();
                data3.content = "四段";
                data.add(datas);
                data.add(data1);
                data.add(data2);
                data.add(data3);
                popupWindow = new ListPopupWindow(this, data);
                popupWindow.setSureListener(new ListPopupWindow.ClickListener() {
                    @Override
                    public void clickListener(DATA menu, int poistion) {
                        tvChoose.setText(menu.content);
                    }
                });
            }

            @Override
            protected void onDestroy() {
                super.onDestroy();

            }


        }

