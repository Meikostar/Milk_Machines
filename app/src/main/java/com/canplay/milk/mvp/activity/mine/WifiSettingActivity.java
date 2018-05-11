package com.canplay.milk.mvp.activity.mine;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.view.MCheckBox;
import com.canplay.milk.view.NavigationBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import socket.util.WifiUtils;

/**
 * wifi设置界面
 */
public class WifiSettingActivity extends BaseActivity {


    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.tv_wifi)
    TextView tvWifi;
    @BindView(R.id.iv_wifi)
    MCheckBox ivWifi;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.tv_names)
    TextView tvNames;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.tv_equptname)
    TextView tvEquptname;
    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.tv_login_status)
    TextView tvLoginStatus;
    @BindView(R.id.tv_get)
    TextView tvGet;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.tv_open)
    TextView tvOpen;

    @Override
    public void initViews() {
        setContentView(R.layout.acitivity_wifi_setting);
        ButterKnife.bind(this);
        navigationBar.setNavigationBarListener(this);
        /**
         * 获取WIFI服务
         */
        if(WifiUtils.shareInstance().isUseable()){
            ivWifi.setChecked(true);
        }else {
            ivWifi.setChecked(false);
        }

        tvName.setText(WifiUtils.shareInstance().getWifiName());
        tvNames.setText(WifiUtils.shareInstance().getWifiName());
    }

    @Override
    public void bindEvents() {
          ivWifi.setOnCheckChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                  if (b) {
                      WifiUtils.shareInstance().openWifi();
                      tvName.setText(WifiUtils.shareInstance().getWifiName());
                      tvNames.setText(WifiUtils.shareInstance().getWifiName());
                  } else {
                      tvName.setText("");
                      tvNames.setText("");
                      tvStatus.setText("wifi已连接");
                      WifiUtils.shareInstance().closeWifi();
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
