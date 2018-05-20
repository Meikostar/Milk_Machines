package com.canplay.milk.mvp.activity.mine;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.bean.UploadFileBean;
import com.canplay.milk.mvp.activity.wiki.SendRecordActivity;
import com.canplay.milk.permission.PermissionConst;
import com.canplay.milk.permission.PermissionGen;
import com.canplay.milk.permission.PermissionSuccess;
import com.canplay.milk.util.SpUtil;
import com.canplay.milk.view.CircleTransform;
import com.canplay.milk.view.NavigationBar;
import com.canplay.milk.view.SquareTransform;
import com.mykar.framework.utils.PhotoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.valuesfeng.picker.ImageSelectActivity;
import io.valuesfeng.picker.Picker;
import io.valuesfeng.picker.widget.ImageLoaderEngine;

/**
 * 用户头像
 */
public class UserAvarActivity extends BaseActivity {


    @BindView(R.id.line)
    View line;
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.tv_choose)
    TextView tvChoose;
    @BindView(R.id.tv_local)
    TextView tvLocal;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    private PhotoUtils photoUtils;
    @Override
    public void initViews() {
        setContentView(R.layout.acitvity_avator);
        ButterKnife.bind(this);
        navigationBar.setNavigationBarListener(this);
        photoUtils = new PhotoUtils(this);
        Glide.with(this).load(SpUtil.getInstance().getAvator()).asBitmap().transform(new SquareTransform(this)).into(ivImg);

//        mWindowAddPhoto = new PhotoPopupWindow(this);
    }
    @PermissionSuccess(requestCode = PermissionConst.REQUECT_CODE_CAMERA)
    public void requestSdcardSuccess() {
        Picker.from(this)
                .count(1)
                .enableCamera(true)
                .setEngine(new ImageLoaderEngine())
                .setAdd_watermark(false)
                .forResult(REQUEST_CODE_CHOOSE);
    }
    /**
     * 删除照片和修改相册的回调
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if(requestCode==REQUEST_CODE_CHOOSE){
                List<String> imgs = data.getStringArrayListExtra(ImageSelectActivity.EXTRA_RESULT_SELECTION);
                String imagePath = photoUtils.getCropImgPath(requestCode, resultCode, data);
                Glide.with(this).load(imagePath).asBitmap().transform(new SquareTransform(this)).placeholder(R.drawable.moren).into(ivImg);

            }

        }
    }
    private int REQUEST_CODE_CHOOSE=2;
    @Override
    public void bindEvents() {
       tvChoose.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               closeKeyBoard();
               PermissionGen.with(UserAvarActivity.this)
                       .addRequestCode(PermissionConst.REQUECT_CODE_CAMERA)
                       .permissions(Manifest.permission.CAMERA,
                               Manifest.permission.WRITE_EXTERNAL_STORAGE,
                               Manifest.permission.READ_EXTERNAL_STORAGE)
                       .request();
           }
       });

    }


    @Override
    public void initData() {

    }

}
