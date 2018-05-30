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

import com.bumptech.glide.Glide;
import com.canplay.medical.R;
import com.canplay.milk.base.BaseFragment;
import com.canplay.milk.base.RxBus;
import com.canplay.milk.base.SubscriptionBean;
import com.canplay.milk.bean.USER;
import com.canplay.milk.mvp.activity.mine.EditorInfoActivity;
import com.canplay.milk.mvp.activity.mine.MineInfoActivity;
import com.canplay.milk.util.SpUtil;
import com.canplay.milk.util.TextUtil;
import com.canplay.milk.util.TimeUtil;
import com.canplay.milk.view.CircleImageView;
import com.canplay.milk.view.CircleTransform;
import com.canplay.milk.view.PhotoPopupWindow;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;
import rx.functions.Action1;


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
    CircleImageView ivImgs;
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
        initdata();
        return view;
    }

    public PhotoPopupWindow mWindowAddPhoto;

    @Override
    public void onResume() {
        super.onResume();

    }

    private USER user;
    private Subscription mSubscription;
    private void initListener() {
        mSubscription = RxBus.getInstance().toObserverable(SubscriptionBean.RxBusSendBean.class).subscribe(new Action1<SubscriptionBean.RxBusSendBean>() {
            @Override
            public void call(SubscriptionBean.RxBusSendBean bean) {
                if (bean == null) return;

                if (bean.type == SubscriptionBean.UPDATE) {
                    initdata();
                }

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        RxBus.getInstance().addSubscription(mSubscription);
     llEditor.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(getActivity(),EditorInfoActivity.class));
         }
     });

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if(mSubscription!=null){
            mSubscription.unsubscribe();
        }
    }
   public void initdata(){
       user= SpUtil.getInstance().getUsers();
       if(user!=null) {
           if (TextUtil.isNotEmpty(user.name)) {
               tvNick.setText(user.name);
           } if (TextUtil.isNotEmpty(user.sex)) {
               tvSex.setText(Integer.valueOf(user.sex)==1?"男":"女");
           }
           if (TextUtil.isNotEmpty(user.weight)) {
               tvWeigh.setText(user.weight+"kg");
           }
           Glide.with(this).load(user.imgResourceKey).asBitmap().transform(new CircleTransform(getActivity())).placeholder(R.drawable.moren).into(ivImgs);

           tvBirth.setText(TimeUtil.formatToMD(Long.valueOf(user.birthday)));
       }
   }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

}
