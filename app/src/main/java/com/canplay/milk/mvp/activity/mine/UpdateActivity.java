package com.canplay.milk.mvp.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.canplay.medical.BuildConfig;
import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.base.BaseApplication;
import com.canplay.milk.base.BaseDailogManager;
import com.canplay.milk.bean.BASE;
import com.canplay.milk.mvp.component.DaggerBaseComponent;
import com.canplay.milk.mvp.present.LoginContract;
import com.canplay.milk.mvp.present.LoginPresenter;
import com.canplay.milk.util.StringUtil;
import com.canplay.milk.util.TextUtil;
import com.canplay.milk.view.MarkaBaseDialog;
import com.canplay.milk.view.NavigationBar;
import com.canplay.milk.view.ProgressDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 检查更新
 */
public class UpdateActivity extends BaseActivity  implements LoginContract.View{

    @Inject
    LoginPresenter presenter;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.tv_update)
    TextView tvUpdate;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.ll_update)
    LinearLayout llUpdate;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_update);
        ButterKnife.bind(this);
        navigationBar.setNavigationBarListener(this);
        DaggerBaseComponent.builder().appComponent(((BaseApplication) getApplication()).getAppComponent()).build().inject(this);
        presenter.attachView(this);
        presenter.getLastestVersion();
//        mWindowAddPhoto = new PhotoPopupWindow(this);
    }

    @Override
    public void bindEvents() {
        tvUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(havaUpdate){
//                    new Thread(new DownloadApk(url)).start();
                }

            }
        });
    }


    @Override
    public void initData() {

    }

   private boolean havaUpdate;
    private BASE base;
    private String url;
    @Override
    public <T> void toEntity(T entity, int type) {
        base= (BASE) entity;
        if(TextUtil.isNotEmpty(base.version)){
            url=base.sdkUrlName;
            String newVersion = base.version;

            String oldVersion = StringUtil.getVersion(this);//"0.17"

            try {
                if (newVersion.compareTo(oldVersion) > 0) {
                    havaUpdate=true;
                    tvVersion.setText("已有新版本："+base.version+ "跟新后体验更多新功能");
                }else {
                    tvUpdate.setText("暂无更新");
                }

            } catch (Exception e) {
//            if (!StringUtil.equals(newVersion, oldVersion)) {
//                hasNew=true;
//            }else {
//                hasNew=false;
//            }
            }
        }
    }



    public class DownloadApk implements Runnable {
        private ProgressDialog dialog;
        InputStream is;
        FileOutputStream fos;
        private Context context;

        public DownloadApk(String  url) {
            this.url=url;
        }
        private String url;
        /**
         * 下载完成,提示用户安装
         */
        private void installApk(File file) {

            //调用系统安装程序
//            Intent intent = new Intent();
//            intent.setAction("android.intent.action.VIEW");
//            intent.addCategory("android.intent.category.DEFAULT");
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            Uri photoURI = FileProvider.getUriForFile(MainActivity.this, MainActivity.this.getApplicationContext().getPackageName() + ".provider", file);
//            intent.setDataAndType(photoURI, "application/vnd.android.package-archive");
//            MainActivity.this.startActivityForResult(intent, 0);
//
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //判断是否是AndroidN以及更高的版本
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri contentUri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", file);
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            startActivityForResult(intent, 0);
        }

        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().get().url(url).build();
            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {

                    //获取内容总长度
                    long contentLength = response.body().contentLength();
                    //设置最大值
                    //保存到sd卡
                    String apkName=url.substring(url.lastIndexOf("/")+1, url.length());
                    File apkFile = new File(Environment.getExternalStorageDirectory(), apkName);
                    fos = new FileOutputStream(apkFile);
                    //获得输入流
                    is = response.body().byteStream();
                    //定义缓冲区大小
                    byte[] bys = new byte[1024];
                    int progress = 0;
                    int len = -1;
                    while ((len = is.read(bys)) != -1) {
                        try {
                            Thread.sleep(1);
                            fos.write(bys, 0, len);
                            fos.flush();
                            progress += len;
                            //设置进度

                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    //下载完成,提示用户安装
                    installApk(apkFile);
                }
            } catch (IOException e) {
                return;
            } finally {
                //关闭io流
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    is = null;
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fos = null;
                }
            }

        }
    }
    @Override
    public void showTomast(String msg) {
        dimessProgress();
         showToasts(msg);
    }
}
