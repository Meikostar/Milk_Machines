package com.canplay.milk.mvp.activity;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;


import com.canplay.medical.R;

import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.base.BaseDailogManager;
import com.canplay.milk.base.RxBus;
import com.canplay.milk.base.SubscriptionBean;
import com.canplay.milk.fragment.FileFragment;
import com.canplay.milk.fragment.HomeFragment;
import com.canplay.milk.fragment.SetFragment;
import com.canplay.milk.fragment.WikiPediaFragment;
import com.canplay.milk.mvp.activity.account.LoginActivity;
import com.canplay.milk.mvp.adapter.FragmentViewPagerAdapter;
import com.canplay.milk.permission.PermissionConst;
import com.canplay.milk.permission.PermissionGen;
import com.canplay.milk.permission.PermissionSuccess;
import com.canplay.milk.receiver.Service1;
import com.canplay.milk.view.BottonNevgBar;
import com.canplay.milk.view.ChangeNoticeDialog;
import com.canplay.milk.view.MarkaBaseDialog;
import com.canplay.milk.view.NoScrollViewPager;

import com.google.zxing.client.android.activity.CaptureActivity;




import java.util.ArrayList;
import java.util.List;


import rx.Subscription;
import rx.functions.Action1;
import android.content.DialogInterface;
public class MainActivity extends BaseActivity {

    NoScrollViewPager viewpagerMain;
    BottonNevgBar bnbHome;
    private Subscription mSubscription;
    private FragmentViewPagerAdapter mainViewPagerAdapter;
    private List<Fragment> mFragments;
    private int current = 0;
    private long firstTime = 0l;
    private SetFragment setFragment;
    private FileFragment fileFragment;
    private HomeFragment homeFragment;
    private WikiPediaFragment wikiPediaFragment;
    private View line;
    private ChangeNoticeDialog dialog;
    private MarkaBaseDialog exitDialog;
    @Override
    public void initViews() {
        setContentView(R.layout.activity_main);
        bnbHome = (BottonNevgBar) findViewById(R.id.bnb_home);
        line =  findViewById(R.id.line);
        PermissionGen.with(MainActivity.this)
                .addRequestCode(PermissionConst.REQUECT_DATE)
                .permissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .request();
        exitDialog= BaseDailogManager.getInstance().getBuilder(this).setOnClickListener(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    finish();
                }else {
                    dialog.dismiss();
                }
            }
        }).create();
        viewpagerMain = (NoScrollViewPager) findViewById(R.id.viewpager_main);
        viewpagerMain.setScanScroll(false);
        dialog=new ChangeNoticeDialog(this,line);

    }
    private void alarm() {
        startService(new Intent(MainActivity.this, Service1.class));

    }
    @Override
    public void bindEvents() {

        setViewPagerListener();
        setNevgBarChangeListener();

        mSubscription = RxBus.getInstance().toObserverable(SubscriptionBean.RxBusSendBean.class).subscribe(new Action1<SubscriptionBean.RxBusSendBean>() {
            @Override
            public void call(SubscriptionBean.RxBusSendBean bean) {
                if (bean == null) return;
                if(SubscriptionBean.MENU_SCAN==bean.type){
                  dialog.show();
                }else if(SubscriptionBean.FINISH==bean.type){
                    finish();
                }


            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        RxBus.getInstance().addSubscription(mSubscription);

        dialog.setBindClickListener(new ChangeNoticeDialog.BindClickListener() {
            @Override
            public void teaMoney(String money) {
                dialog.dismiss();
            }
        });
    }
    @Override
    public void initData() {
        addFragment();
        mainViewPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), mFragments);
        viewpagerMain.setAdapter(mainViewPagerAdapter);
        viewpagerMain.setOffscreenPageLimit(3);//设置缓存view 的个数
        viewpagerMain.setCurrentItem(current);
        bnbHome.setSelect(current);

    }

    private void setViewPagerListener() {
        viewpagerMain.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                bnbHome.setSelect(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setNevgBarChangeListener() {
        bnbHome.setOnChangeListener(new com.canplay.milk.view.OnChangeListener() {
            @Override
            public void onChagne(int currentIndex) {
                current = currentIndex;
                bnbHome.setSelect(currentIndex);alarm();
                viewpagerMain.setCurrentItem(currentIndex);
            }
        });
    }

    private void addFragment() {
        mFragments = new ArrayList<>();

        setFragment=new SetFragment();
        fileFragment=new FileFragment();
        homeFragment=new HomeFragment();
        wikiPediaFragment=new WikiPediaFragment();
        mFragments.add(homeFragment);
        mFragments.add(wikiPediaFragment);
        mFragments.add(fileFragment);
        mFragments.add(setFragment);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSubscription != null) {
            RxBus.getInstance().unSub(mSubscription);
        }
        if(exitDialog!=null){
            exitDialog.dismiss();
        }
    }

    @PermissionSuccess(requestCode = PermissionConst.REQUECT_CODE_CAMERA)
    public void requestSdcardSuccess() {
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
         /*ZxingConfig是配置类  可以设置是否显示底部布局，闪光灯，相册，是否播放提示音  震动等动能
         * 也可以不传这个参数
         * 不传的话  默认都为默认不震动  其他都为true
         * */

        //ZxingConfig config = new ZxingConfig();
        //config.setShowbottomLayout(true);//底部布局（包括闪光灯和相册）
        //config.setPlayBeep(true);//是否播放提示音
        //config.setShake(true);//是否震动
        //config.setShowAlbum(true);//是否显示相册
        //config.setShowFlashLight(true);//是否显示闪光灯
        //intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    private int REQUEST_CODE_SCAN=6;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra("scan_result");
                showToasts("扫描结果为：" +content);
//                result.setText("扫描结果为：" + content);
            }
        }
    }


    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_BACK:
                exitDialog.show();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
