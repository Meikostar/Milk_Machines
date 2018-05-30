package com.canplay.milk.mvp.activity.home;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.base.BaseDailogManager;
import com.canplay.milk.base.RxBus;
import com.canplay.milk.base.SubscriptionBean;
import com.canplay.milk.bean.AlarmClock;
import com.canplay.milk.mvp.adapter.FragmentViewPagerAdapter;
import com.canplay.milk.mvp.adapter.RemindMeasureAdapter;
import com.canplay.milk.util.MyUtil;
import com.canplay.milk.util.SpUtil;
import com.canplay.milk.view.MCheckBox;
import com.canplay.milk.view.MarkaBaseDialog;
import com.canplay.milk.view.NavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.functions.Action1;

/**
 * 冲奶提醒
 */
public class RemindMilkActivity extends BaseActivity {


    @BindView(R.id.line)
    View line;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.tv_remind)
    TextView tvRemind;

    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.iv_choose)
    MCheckBox ivChoose;
    @BindView(R.id.rl_menu)
    ListView rlMenu;


    @Override
    public void initViews() {
        setContentView(R.layout.activity_remind_health);
        ButterKnife.bind(this);
        navigationBar.setNavigationBarListener(this);
        type = getIntent().getIntExtra("type", 0);
        if (type != 0) {
            tvAdd.setVisibility(View.VISIBLE);
        }

    }


    private int status;

    @Override
    public void bindEvents() {


        navigationBar.setNavigationBarListener(new NavigationBar.NavigationBarListener() {
            @Override
            public void navigationLeft() {
                finish();
            }

            @Override
            public void navigationRight() {


            }

            @Override
            public void navigationimg() {

            }
        });
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(RemindMilkActivity.this, RemindSettingActivity.class), 0);

            }
        });

    }

    private RemindMeasureAdapter adapter;
    @Override
    public void initData() {
        adapter = new RemindMeasureAdapter(this);
        rlMenu.setAdapter(adapter);

        mSubscription = RxBus.getInstance().toObserverable(SubscriptionBean.RxBusSendBean.class).subscribe(new Action1<SubscriptionBean.RxBusSendBean>() {
            @Override
            public void call(SubscriptionBean.RxBusSendBean bean) {
                if (bean == null) return;
                if (SubscriptionBean.MESURE == bean.type) {
                    setData();
                }


            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        RxBus.getInstance().addSubscription(mSubscription);

        adapter.setListener(new RemindMeasureAdapter.selectItemListener() {
            @Override
            public void delete(AlarmClock medicine, int type, int poistion) {
              if(type==6){
                  alarmClock=medicine;
                  showDailog("删除"+medicine.getHour()+":"+medicine.getMinute()+"闹铃");
              }

            }
        });
        setData();

    }

    private AlarmClock alarmClock;
    private MarkaBaseDialog dialog;
    public void showDailog(String  content) {

            if(dialog!=null){
                dialog.cancel();
            }
            dialog = BaseDailogManager.getInstance().getBuilder(this).setRightButtonText("取消").setLeftButtonText("确定").setTitle("删除闹钟").setMessage(content).setOnClickListener(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    if(which==BaseDailogManager.LEFT_BUTTON){
                        List<AlarmClock> allAlarm = SpUtil.getInstance().getAllAlarm();
                        for(AlarmClock alarm:allAlarm){
                            if(alarmClock.getId()==alarm.getId()){
                                // 取得格式化后的时间
                                String time = MyUtil.formatTime(alarm.getHour(),
                                        alarmClock.getMinute());
                                SpUtil.getInstance().putString( time, "");
                                // 关闭闹钟
                                MyUtil.cancelAlarmClock(RemindMilkActivity.this,
                                        alarmClock.getId());
                                // 关闭小睡
                                MyUtil.cancelAlarmClock(RemindMilkActivity.this,
                                        -alarmClock.getId());

                                NotificationManager notificationManager = (NotificationManager) RemindMilkActivity.this
                                        .getSystemService(Activity.NOTIFICATION_SERVICE);
                                // 取消下拉列表通知消息
                                notificationManager.cancel(alarmClock.getId());
                                setData();
                            }
                        }
                        dialog.dismiss();
                    }else {
                        dialog.dismiss();
                    }
                }
            }).create();

            dialog.show();



    }
    private Subscription mSubscription;
    public void setData(){
        List<AlarmClock> allAlarm = SpUtil.getInstance().getAllAlarm();
        adapter.setData(allAlarm);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mSubscription!=null){
            mSubscription.unsubscribe();
        }
    }
}
