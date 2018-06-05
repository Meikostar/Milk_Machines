package com.canplay.milk.mvp.adapter.recycle;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.bean.Vaccines;
import com.canplay.milk.util.TextUtil;
import com.canplay.milk.util.TimeUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by mykar on 17/4/12.
 */
public class NerseryCycleAdapter extends BaseRecycleViewAdapter {



    private Context context;
    private int type;
    private int status;

    public NerseryCycleAdapter(Context context, int type) {
        this.context = context;
        this.type = type;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nersery, null);

        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holders = (ViewHolder) holder;
        Vaccines vaccines= (Vaccines) datas.get(position);
        if(TextUtil.isNotEmpty(vaccines.name)){
            if(System.currentTimeMillis()>vaccines.updateTime){
                if(vaccines.frequency==0){
                    holders.tvName.setText(vaccines.name+"(初次,未接种)");
                }else {
                    holders.tvName.setText(vaccines.name+"(第"+vaccines.frequency+"次,已接种)");
                }
                holders.tvName.setTextColor(context.getResources().getColor(R.color.a0));
                holders.tvTime.setTextColor(context.getResources().getColor(R.color.a0));
                holders.tvTime.setText(TimeUtil.formatTims(vaccines.updateTime));
            }else {
                if(vaccines.frequency==0){
                    holders.tvName.setText(vaccines.name+"(初次,未接种)");
                }else {
                    holders.tvName.setText(vaccines.name+"(第"+vaccines.frequency+"次,未接种)");
                }

                holders.tvTime.setText(TimeUtil.formatTims(vaccines.updateTime));
                holders.tvName.setTextColor(context.getResources().getColor(R.color.slow_black));
                holders.tvTime.setTextColor(context.getResources().getColor(R.color.slow_black));
            }
        }



    }

    @Override
    public int getItemCount() {
        int count = 0;

        if (datas != null && datas.size() > 0) {
            count = datas.size();
        }

        return count;
    }

    public void setClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public OnItemClickListener listener;

    public interface OnItemClickListener {
        void clickListener(int type, String data);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_time)
        TextView tvTime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
