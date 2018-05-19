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
import com.canplay.milk.base.BaseApplication;
import com.canplay.milk.base.BaseFragment;
import com.canplay.milk.bean.ShareBean;
import com.canplay.milk.mvp.activity.home.AddMilkActivity;
import com.canplay.milk.mvp.activity.home.RemindMilkActivity;
import com.canplay.milk.mvp.activity.mine.MineInfoActivity;
import com.canplay.milk.mvp.component.DaggerBaseComponent;
import com.canplay.milk.util.ThirdShareManager;
import com.canplay.milk.view.EditorNameDialog;
import com.canplay.milk.view.PhotoPopupWindow;
import com.canplay.milk.view.PopView_NavigationBar_Menu;
import com.canplay.milk.view.SharePopupWindow;

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
    @BindView(R.id.iv_pop)
    ImageView ivPop;


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
        sharePopupWindow = new SharePopupWindow(getActivity());
        sharePopupWindow.setSureListener(new SharePopupWindow.ClickListener() {
            @Override
            public void clickListener(int type) {
                if(type==1){
                    ThirdShareManager.getInstance().shareWeChat(new ShareBean(),true);
                }else {
                    ThirdShareManager.getInstance().shareWeChat(new ShareBean(),false);
                }
                sharePopupWindow.dismiss();
            }
        });
        mWindowAddPhoto.setCont("解除绑定", "取消");
        mWindowAddPhoto.setColor(R.color.red_pop, 0);
        initPopView();
        initListener();
        return view;
    }

    public PhotoPopupWindow mWindowAddPhoto;
    public SharePopupWindow sharePopupWindow;
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
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddMilkActivity.class));
            }
        });
        ivPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popView_navigationBar.showPopView();
//                sharePopupWindow.showAsDropDown(line);
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

    /**
     * popwindow
     */
    private PopView_NavigationBar_Menu popView_navigationBar;

    private void initPopView() {
//        mWindowAddPhoto = new PhotoPopupWindow(getActivity());
        popView_navigationBar = new PopView_NavigationBar_Menu(getActivity(), 1);
        popView_navigationBar.setView(line);

        popView_navigationBar.setClickListener(new PopView_NavigationBar_Menu.ItemCliskListeners() {
            @Override
            public void clickListener(int poition) {
                switch (poition) {
                    case 0://冲奶提醒
                     startActivity(new Intent(getActivity(),RemindMilkActivity.class));
                        break;
                    case 1://WIFI设置
                        startActivity(new Intent(getActivity(),RemindMilkActivity.class));
                        break;
                    case 2://饮水设置

                        break;
                    case 3://跟换奶粉品牌
                        break;
                }
                popView_navigationBar.dismiss();
            }

        });
    }
}
