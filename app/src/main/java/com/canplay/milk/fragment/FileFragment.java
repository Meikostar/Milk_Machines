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
import com.canplay.milk.mvp.activity.mine.MineInfoActivity;
import com.canplay.milk.view.PhotoPopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 档案
 */
public class FileFragment extends BaseFragment implements View.OnClickListener {

    Unbinder unbinder;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.tv_birth)
    TextView tvBirth;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.iv_imgs)
    ImageView ivImgs;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.tv_weigh)
    TextView tvWeigh;
    @BindView(R.id.ll_editor)
    LinearLayout llEditor;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.ll_expend)
    LinearLayout llExpend;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_text1)
    TextView tvText1;
    @BindView(R.id.tv_text2)
    TextView tvText2;
    @BindView(R.id.tv_text3)
    TextView tvText3;
    @BindView(R.id.tv_text4)
    TextView tvText4;
    @BindView(R.id.tv_text5)
    TextView tvText5;
    @BindView(R.id.tv_text6)
    TextView tvText6;
    @BindView(R.id.tv_text7)
    TextView tvText7;
    @BindView(R.id.tv_text8)
    TextView tvText8;
    @BindView(R.id.tv_text9)
    TextView tvText9;
    @BindView(R.id.tv_time)
    TextView tvTime;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.file_fragment, null);
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
