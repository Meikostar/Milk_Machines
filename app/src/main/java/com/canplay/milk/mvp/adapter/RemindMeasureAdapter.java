package com.canplay.milk.mvp.adapter;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.bean.AlarmClock;
import com.canplay.milk.bean.RemindMilk;
import com.canplay.milk.mvp.component.AlarmClockUpdateEvent;
import com.canplay.milk.util.AlarmClockOperate;
import com.canplay.milk.util.AudioPlayer;
import com.canplay.milk.util.MyUtil;
import com.canplay.milk.view.MCheckBox;
import com.canplay.milk.view.SwipeListLayout;
import com.google.zxing.client.android.utils.OttoAppConfig;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by honghouyang on 16/12/23.
 */

public class RemindMeasureAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<AlarmClock> list;
    private int type;
    private ListView lv_content;
    private Set<SwipeListLayout> sets = new HashSet();
    private selectItemListener listener;
    public interface selectItemListener{
        void delete(AlarmClock medicine, int type, int poistion);
    }
    public void setListener(selectItemListener listener){
        this.listener=listener;
    }
    public void setData( List<AlarmClock> list){
        this.list=list;
        notifyDataSetChanged();
    }
    public List<AlarmClock> getDatas(){
        return list;
    }
    public RemindMeasureAdapter(Context context) {

        this.context = context;
        this.list = list;

    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public int getCount() {
        return list!=null?(list.size()==0?0:list.size()):3;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_remind_mesure, parent, false);
            holder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tvState = (TextView) convertView.findViewById(R.id.tv_state);
            holder.tvDay = (TextView) convertView.findViewById(R.id.tv_day);
            holder.ivchoose = (MCheckBox) convertView.findViewById(R.id.iv_choose);
            holder.llbg = (LinearLayout) convertView.findViewById(R.id.ll_bg);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        alarmClock=list.get(position);
          holder.llbg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  listener.delete(list.get(position),1,position);
              }
          });
        if(list.get(position).isOnOff()){
            holder.ivchoose.setChecked(true);
        }else {
            holder.ivchoose.setChecked(false);
        }
        holder.ivchoose.setOnCheckChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // 闹钟状态为开的话不更新数据
                    if (!list.get(position).isOnOff()) {
                        updateTab(true);
                    }
                } else {
                    // 闹钟状态为关的话不处理
                    if (!list.get(position).isOnOff()) {
                        return;
                    }
                    updateTab(false);
                    // 取消闹钟
                    MyUtil.cancelAlarmClock(context,
                            list.get(position).getId());
                    // 取消小睡
                    MyUtil.cancelAlarmClock(context,
                            -list.get(position).getId());

                    NotificationManager notificationManager = (NotificationManager) context.
                            getSystemService(
                                    Activity.NOTIFICATION_SERVICE);
                    // 取消下拉列表通知消息
                    notificationManager.cancel(list.get(position).getId());

                    // 停止播放
                    AudioPlayer.getInstance(context).stop();


                }

            }
        });
        // 取得格式化后的时间
        String time = MyUtil.formatTime(alarmClock.getHour(),
                alarmClock.getMinute());
        // 设定闹钟时间的显示
        holder.tvTime.setText(time);
        // 设定重复的显示
        holder.tvDay.setText(alarmClock.getRepeat());
        // 设定标签的显示
        holder.tvState.setText(alarmClock.getTag());

//          if(TextUtil.isNotEmpty(list.get(position).items.get(0).name)){
//              holder.tvContent.setText(list.get(position).items.get(0).name);
//          } if(TextUtil.isNotEmpty(list.get(position).when)){
//            holder.tvTime.setText(list.get(position).when);
//        }
//        if(list.get(position).completedForToday){
//            holder.ivchoose.setChecked(true);
//        }else {
//            holder.ivchoose.setChecked(false);
//        }

        return convertView;
    }
    private AlarmClock alarmClock;
    /**
     * 更新闹钟列表
     *
     * @param onOff
     *            开关
     */
    private void updateTab(boolean onOff) {
        // 更新闹钟数据
//                        TabAlarmClockOperate.getInstance(mContext).update(onOff,
//                                alarmClock.getAlarmClockCode());
        AlarmClockOperate.getInstance().updateAlarmClock(onOff,
                alarmClock.getId());
        OttoAppConfig.getInstance().post(new AlarmClockUpdateEvent());
    }
    class ViewHolder {

        TextView tvTime;
        TextView tvState;
        MCheckBox ivchoose;

        TextView tvDay;

        LinearLayout llbg;
    }
}
