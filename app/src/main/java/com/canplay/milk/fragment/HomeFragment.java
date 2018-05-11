package com.canplay.milk.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseFragment;
import com.canplay.milk.mvp.activity.mine.MineInfoActivity;
import com.canplay.milk.view.EditorNameDialog;
import com.canplay.milk.view.PhotoPopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by mykar on 17/4/10.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    Unbinder unbinder;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tv_mol)
    TextView tvMol;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.tv_zqx)
    TextView tvZqx;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.tv_milk)
    TextView tvMilk;
    @BindView(R.id.tv_change)
    TextView tvChange;
    @BindView(R.id.tv_ym)
    TextView tvYm;
    @BindView(R.id.tv_time)
    TextView tvTime;


    private EditorNameDialog dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, null);
        unbinder = ButterKnife.bind(this, view);


        mWindowAddPhoto = new PhotoPopupWindow(getActivity());
        mWindowAddPhoto.setCont("解除绑定", "取消");
        mWindowAddPhoto.setColor(R.color.red_pop, 0);
        initListener();
        return view;
    }

    public PhotoPopupWindow mWindowAddPhoto;

    @Override
    public void onResume() {
        super.onResume();

    }


    private void initListener() {
        ivImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MineInfoActivity.class));

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
