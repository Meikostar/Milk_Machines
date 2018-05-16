package com.canplay.milk.fragment;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseApplication;
import com.canplay.milk.base.BaseFragment;
import com.canplay.milk.base.RxBus;
import com.canplay.milk.base.SubscriptionBean;
import com.canplay.milk.bean.BASE;
import com.canplay.milk.bean.RemindMilk;
import com.canplay.milk.mvp.adapter.RemindMeasureAdapter;
import com.canplay.milk.mvp.component.DaggerBaseComponent;
import com.canplay.milk.mvp.present.BaseContract;
import com.canplay.milk.mvp.present.BasesPresenter;
import com.canplay.milk.util.TextUtil;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;
import rx.functions.Action1;


/**
 * 测量提醒
 */
public class RemindFragment extends BaseFragment implements BaseContract.View {

    @Inject
    BasesPresenter presenter;

    @BindView(R.id.rl_menu)
    ListView rlMenu;
    Unbinder unbinder;
    private RemindMeasureAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remind_medical, null);
//        DaggerBaseComponent.builder().appComponent(((BaseApplication) getActivity().getApplication()).getAppComponent()).build().inject(this);
//
//        presenter.attachView(this);

//        presenter.MeasureRemindList();
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private Subscription mSubscription;
    private void initView() {
        adapter = new RemindMeasureAdapter(getActivity());
        rlMenu.setAdapter(adapter);
        mSubscription = RxBus.getInstance().toObserverable(SubscriptionBean.RxBusSendBean.class).subscribe(new Action1<SubscriptionBean.RxBusSendBean>() {
            @Override
            public void call(SubscriptionBean.RxBusSendBean bean) {
                if (bean == null) return;
                if(SubscriptionBean.MESURE==bean.type){
                  String cont= (String) bean.content;
                    if(TextUtil.isNotEmpty(cont)){
                        return;
                    }
//                    presenter.MeasureRemindList();
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
            public void delete(RemindMilk medicine, int type, int poistion) {



            }
        });

    }
    private String name="";
    private String time="";
//    private Mesure mesure=new Mesure();
    private List<String> times=new ArrayList<>();

//
//    /**
//     * 保存闹钟信息的list
//     */
//    private List<AlarmClock> mAlarmClockList;
//    private void addList(AlarmClock ac) {
//        mAlarmClockList.clear();
//
//        int id = ac.getId();
//        int count = 0;
//        int position = 0;
//        List<AlarmClock> list = AlarmClockOperate.getInstance().loadAlarmClocks();
//        for (AlarmClock alarmClock : list) {
//            mAlarmClockList.add(alarmClock);
//
//            if (id == alarmClock.getId()) {
//                position = count;
//                if (alarmClock.isOnOff()) {
//                    MyUtil.startAlarmClock(getActivity(), alarmClock);
//                }
//            }
//            count++;
//        }
//
//        checkIsEmpty(list);
//
//
//    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }
    private void checkIsEmpty(List<AlarmClock> list) {
        if (list.size() != 0) {
            rlMenu.setVisibility(View.VISIBLE);
//            mEmptyView.setVisibility(View.GONE);
        } else {
            rlMenu.setVisibility(View.GONE);
//            mEmptyView.setVisibility(View.VISIBLE);


        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mSubscription!=null){
            mSubscription.unsubscribe();
        }

    }

//    private List<Medicine> data;
    private int i=0;
    @Override
    public <T> void toEntity(T entity,int type) {
//        if(type==6){
//            BASE base= (BASE) entity;
//            if(base.isSucceeded){
//                data.remove(poition);
//                adapter.setData(data);
//                List<AlarmClock> alarmClocks = AlarmClockOperate.getInstance().loadAlarmClocks();
//                for(AlarmClock alarmClock:alarmClocks){
//                    if(TextUtil.isNotEmpty(time)){
//                        String[] split = time.split(":");
//                        if(alarmClock.getHour()==Integer.valueOf(split[0])&&alarmClock.getMinute()==Integer.valueOf(split[1])){
//                            AlarmClockOperate.getInstance().deleteAlarmClock(alarmClock);
//
//                            // 关闭闹钟
//                            MyUtil.cancelAlarmClock(getActivity(),
//                                    alarmClock.getId());
//                            // 关闭小睡
//                            MyUtil.cancelAlarmClock(getActivity(),
//                                    -alarmClock.getId());
//
//                            NotificationManager notificationManager = (NotificationManager) getActivity()
//                                    .getSystemService(Activity.NOTIFICATION_SERVICE);
//                            // 取消下拉列表通知消息
//                            notificationManager.cancel(alarmClock.getId());
//                        }
//                    }
//                }
//
//            }else {
//                if(i!=0){
//                    return;
//                }
//                i++;
//                times.clear();
//                times.addAll(base.when);
//                mesure.name=name;
//                mesure.when=times;
//                String userId = SpUtil.getInstance().getUserId();
//                mesure.userId=userId;
//                mesure.type="time";
//                mesure.remindingFor="Measurement";
//                presenter.addMesure(mesure);
//            }
//        }else {
//            data= (List<Medicine>) entity;
//
//            adapter.setData(data);
//        }

    }
    private int poition;
    @Override
    public void toNextStep(int type) {

    }


    @Override
    public void showTomast(String msg) {

    }
}