package com.canplay.milk.mvp.activity.wiki;

import android.Manifest;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.bean.UploadFileBean;
import com.canplay.milk.permission.PermissionConst;
import com.canplay.milk.permission.PermissionFail;
import com.canplay.milk.permission.PermissionGen;
import com.canplay.milk.permission.PermissionSuccess;
import com.canplay.milk.util.TextUtil;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.ImageUploadView;
import com.canplay.milk.view.NavigationBar;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import io.valuesfeng.picker.ImageSelectActivity;
import io.valuesfeng.picker.Picker;
import io.valuesfeng.picker.widget.ImageLoaderEngine;

/***
 * 记录编辑
 */
public class SendRecordActivity extends BaseActivity  {

    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.et_content)
    ClearEditText etContent;
    @BindView(R.id.iv_add_photo)
    TextView ivAddPhoto;
    @BindView(R.id.piuv_remark_image)
    ImageUploadView piuvRemarkImage;
    @BindView(R.id.tv_time)
    TextView txtTime;
    @BindView(R.id.ll_bottom_button)
    View llBottomButton;


    private List<File> files=new ArrayList<>();

    private ArrayList<UploadFileBean> img_path = new ArrayList<>();
    private int i=1;
    private String url;
    private String content;

    private int count=9;


    @Override
    public void initViews() {
        setContentView(R.layout.activity_send_dynamic);
        ButterKnife.bind(this);
        navigationBar.setNavigationBarListener(this);

    }

    @Override
    public void bindEvents() {
        piuvRemarkImage.setOnActionListener(new ImageUploadView.OnActionListener() {
            @Override
            public void onItemDelete(int position) {
                img_path.remove(position);

                notifyImageDataChange();
            }

            @Override
            public void onItemClick(int position) {
            }

            @Override
            public void onAddMoreClick() {
                if(count-img_path.size()>=1){


                }

            }

            @Override
            public void onItemPositionChange() {
                //mUploadView.notifyItemChange(0);
            }
        });
        etContent.setOnClearEditTextListener(new ClearEditText.ClearEditTextListener() {
            @Override
            public void afterTextChanged4ClearEdit(Editable s) {

            }

            @Override
            public void changeText(CharSequence s) {
                   if(TextUtil.isNotEmpty(s.toString())){
                       content=  s.toString();

                   }else {
                       content= "";

                   }

            }
        });
//        txtSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showProgress(getString(R.string.fabuz));
//                for(UploadFileBean bean :img_path){
//                    File file = new File(bean.getForderPath());
//                    files.add(file);
//                }
//                if(files!=null&&files.size()>0){
//                    model.submitImg(1,files.get(0),SendDynamicActivity.this);
//                }else {
//                    chatmodel.sendQFriend(content,url,SendDynamicActivity.this);
//                }
//            }
//        });
        ivAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyBoard();
                PermissionGen.with(SendRecordActivity.this)
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
    @PermissionSuccess(requestCode = PermissionConst.REQUECT_CODE_CAMERA)
    public void requestSdcardSuccess() {
        Picker.from(this)
                .count(count)
                .enableCamera(true)
                .setEngine(new ImageLoaderEngine())
                .setAdd_watermark(false)
                .forResult(REQUEST_CODE_CHOOSE);
    }

    @PermissionFail(requestCode = PermissionConst.REQUECT_CODE_CAMERA)
    public void requestSdcardFailed() {
//        showToast(getString(R.string.getqxdefault));
    }
   private int REQUEST_CODE_CHOOSE=3;
    private int upload_position;
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

                for (String imgPath : imgs) {
                    if (imgPath != null) {
                        UploadFileBean bean = new UploadFileBean(1);
                        bean.setForderPath(imgPath);
                        img_path.add(bean);
                    }
                }

                notifyImageDataChange();
                upload_position = 0;
            }

        }
    }


    public void getUpImgSuccdess(String info) {
        if(files.size()>i){
            if(i==1){
                url=info;
            }else {
                url=url+","+info;
            }


            i++;
        }else {
            if(i==1){
                url=info;
            }else {
                url=url+","+info;
            }


        }
    }
    private void notifyImageDataChange() {
        if (img_path == null || img_path.size() == 0) {
            ivAddPhoto.setVisibility(View.VISIBLE);
            piuvRemarkImage.setVisibility(View.GONE);
        } else {
            piuvRemarkImage.setVisibility(View.VISIBLE);
            ivAddPhoto.setVisibility(View.GONE);
        }
        piuvRemarkImage.setData(img_path);
    }

}
