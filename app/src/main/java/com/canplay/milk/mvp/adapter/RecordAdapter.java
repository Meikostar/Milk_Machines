package com.canplay.milk.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.canplay.medical.R;
import com.canplay.milk.bean.DATA;
import com.canplay.milk.bean.WIPI;
import com.canplay.milk.util.TextUtil;

import java.util.List;


public class RecordAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> list;
    private int type=0;//1是用药记录item
    public RecordAdapter(Context mContext) {

        this.mContext = mContext;
    }

    public interface ItemCliks{
        void getItem(DATA menu, int type);//type 1表示点击事件2 表示长按事件
    }
    private ItemCliks listener;
    public void setClickListener(ItemCliks listener){
        this.listener=listener;
    }
    public void setData(List<String> list){
        this.list=list;
        notifyDataSetChanged();
    }


    public void setType(int type){
        this.type=type;

    }
    @Override
    public int getCount() {
        return list!=null?list.size():0;
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
    public View getView(final int position, View view, ViewGroup parent) {
        ResultViewHolder holder;
        if (view == null){
            holder = new ResultViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_record, parent, false);
            holder.img= (ImageView) view.findViewById(R.id.iv_img);


            view.setTag(holder);
        }else{
            holder = (ResultViewHolder) view.getTag();
        }
        Glide.with(mContext).load(list.get(position)).asBitmap().placeholder(R.drawable.icon_home_pm_pic).into(holder.img);
        return view;


    }

    public  class ResultViewHolder{

        ImageView img;



    }
}
