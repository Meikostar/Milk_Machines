package com.canplay.milk.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseFragment;
import com.canplay.milk.mvp.activity.wiki.GroupRecordActivity;
import com.canplay.milk.mvp.activity.wiki.LookTImeActivity;
import com.canplay.milk.mvp.activity.wiki.PastWipiActivity;
import com.canplay.milk.mvp.activity.wiki.SeachResultActivity;
import com.canplay.milk.view.PhotoPopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 百科
 */
public class WikiPediaFragment extends BaseFragment implements View.OnClickListener {

    Unbinder unbinder;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.tv_ym)
    TextView tvYm;
    @BindView(R.id.ll_group)
    LinearLayout llGroup;
    @BindView(R.id.bai3)
    ImageView bai3;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_first)
    ImageView ivFirst;
    @BindView(R.id.ll_past)
    LinearLayout llPast;
    @BindView(R.id.ll_pass)
    LinearLayout llPass;
    @BindView(R.id.tv_time)
    LinearLayout llTime;
    @BindView(R.id.ll_record)
    LinearLayout llRecord;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wikipedia_fragment, null);
        unbinder = ButterKnife.bind(this, view);


        initListener();
        return view;
    }

    public PhotoPopupWindow mWindowAddPhoto;

    @Override
    public void onResume() {
        super.onResume();

    }


    private void initListener() {
        llTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LookTImeActivity.class));

            }
        });
        llGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GroupRecordActivity.class));
            }
        });
        llRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SeachResultActivity.class));
            }
        });
        llPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PastWipiActivity.class));
            }
        });
    }

    private void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

}
