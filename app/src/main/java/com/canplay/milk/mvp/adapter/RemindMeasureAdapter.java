package com.canplay.milk.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.bean.RemindMilk;
import com.canplay.milk.view.MCheckBox;
import com.canplay.milk.view.SwipeListLayout;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by honghouyang on 16/12/23.
 */

public class RemindMeasureAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<RemindMilk> list;
    private int type;
    private ListView lv_content;
    private Set<SwipeListLayout> sets = new HashSet();
    private selectItemListener listener;
    public interface selectItemListener{
        void delete(RemindMilk medicine, int type, int poistion);
    }
    public void setListener(selectItemListener listener){
        this.listener=listener;
    }
    public void setData( List<RemindMilk> list){
        this.list=list;
        notifyDataSetChanged();
    }
    public List<RemindMilk> getDatas(){
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


          holder.llbg.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  listener.delete(list.get(position),1,position);
              }
          });
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

    class ViewHolder {

        TextView tvTime;
        TextView tvState;
        MCheckBox ivchoose;

        TextView tvDay;

        LinearLayout llbg;
    }
}
