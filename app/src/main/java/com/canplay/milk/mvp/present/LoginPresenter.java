package com.canplay.milk.mvp.present;


import android.support.annotation.NonNull;


import com.canplay.milk.base.manager.ApiManager;
import com.canplay.milk.bean.BASE;
import com.canplay.milk.bean.USER;
import com.canplay.milk.mvp.http.BaseApi;
import com.canplay.milk.net.MySubscriber;
import com.canplay.milk.util.SpUtil;
import com.canplay.milk.util.StringUtil;

import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;

import rx.Subscription;


public class LoginPresenter implements LoginContract.Presenter {
    private Subscription subscription;

    private LoginContract.View mView;

    private BaseApi contactApi;

    @Inject
    LoginPresenter(ApiManager apiManager){
        contactApi = apiManager.createApi(BaseApi.class);
    }
    @Override
    public void goLogin(String mobile, String pwd) {
        Map<String, String> params = new TreeMap<>();
        params.put("mobile", mobile);
        params.put("pwd", StringUtil.md5(pwd));
        subscription = ApiManager.setSubscribe(contactApi.Login(ApiManager.getParameters(params, true)), new MySubscriber<USER>(){
            @Override
            public void onError(Throwable e){
                super.onError(e);

                mView.showTomast(e.getMessage());


            }

            @Override
            public void onNext(USER entity){
                mView.toEntity(entity,0);
                SpUtil.getInstance().putUser(entity);
            }
        });
    }
    @Override
    public void resetPwd(String mobile, String resetCode, String pwd) {
        Map<String, String> params = new TreeMap<>();
        params.put("mobile", mobile);
        params.put("resetCode", resetCode);
        params.put("pwd", StringUtil.md5(pwd));
        params.put("rePwd", StringUtil.md5(pwd));
        subscription = ApiManager.setSubscribe(contactApi.resetPwd(ApiManager.getParameters(params, true)), new MySubscriber<USER>(){
            @Override
            public void onError(Throwable e){
                super.onError(e);

                mView.showTomast(e.getMessage());


            }

            @Override
            public void onNext(USER entity){
                mView.toEntity(entity,2);

//                SpUtil.getInstance().putString(SpUtil.USER_ID,entity.merchantId);
            }
        });
    }
    @Override
    public void getLastestVersion() {
        Map<String, String> params = new TreeMap<>();
        params.put("platformType", "Android");
        subscription = ApiManager.setSubscribe(contactApi.getLastestVersion(ApiManager.getParameters(params, true)), new MySubscriber<BASE>(){
            @Override
            public void onError(Throwable e){
                super.onError(e);

                mView.showTomast(e.getMessage());


            }

            @Override
            public void onNext(BASE entity){
                mView.toEntity(entity,2);

//                SpUtil.getInstance().putString(SpUtil.USER_ID,entity.merchantId);
            }
        });
    }

    @Override
    public void mobileRegister(String mobile, String regCode, String pwd,
                               String birthDate, String name, String sex, String weight) {
        Map<String, String> params = new TreeMap<>();
        params.put("mobile", mobile);
        params.put("regCode", regCode);
        params.put("pwd", pwd);
        params.put("rePwd", pwd);
        params.put("birthDate", birthDate);
        params.put("name", name);
        params.put("sex", sex);
        params.put("weight", weight);
        subscription = ApiManager.setSubscribe(contactApi.mobileRegister(ApiManager.getParameters(params, true)), new MySubscriber<USER>(){
            @Override
            public void onError(Throwable e){
                super.onError(e);

                mView.showTomast(e.getMessage());


            }

            @Override
            public void onNext(USER entity){
                mView.toEntity(entity,0);
                SpUtil.getInstance().putUser(entity);
//                SpUtil.getInstance().putString(SpUtil.USER_ID,entity.merchantId);
            }
        });
    }

    @Override
    public void updateMyBaseInfo(String name, String fatherName, String motherName) {
        Map<String, String> params = new TreeMap<>();

        params.put("name", name);
        params.put("fatherName", fatherName);
        params.put("motherName", motherName);
        subscription = ApiManager.setSubscribe(contactApi.updateMyBaseInfo(ApiManager.getParameters(params, true)), new MySubscriber<USER>(){
            @Override
            public void onError(Throwable e){
                super.onError(e);

                mView.showTomast(e.getMessage());


            }

            @Override
            public void onNext(USER entity){
                mView.toEntity(entity,0);
                SpUtil.getInstance().putUser(entity);
//                SpUtil.getInstance().putString(SpUtil.USER_ID,entity.merchantId);
            }
        });
    }


    @Override
    public void downApk() {

        Map<String, String> params = new TreeMap<>();
        subscription = ApiManager.setSubscribe(contactApi.downApk(ApiManager.getParameters(params, true)), new MySubscriber<BASE >() {
            @Override
            public void onNext(BASE ruslt) {

                mView.toEntity(ruslt,0);

            }

            @Override
            public void onError(Throwable e) {

                super.onError(e);
                mView.showTomast(e.getMessage());
            }
        });
    }


    @Override
    public void getMyBaseInfo() {

        Map<String, String> params = new TreeMap<>();


        subscription = ApiManager.setSubscribe(contactApi.getMyBaseInfo(ApiManager.getParameters(params, true)), new MySubscriber<USER >() {
            @Override
            public void onNext(USER ruslt) {

                mView.toEntity(ruslt,0);

            }

            @Override
            public void onError(Throwable e) {

                super.onError(e);
                mView.showTomast(e.getMessage());
            }
        });
    }

    @Override
    public void getCode(String phone) {

        Map<String, String> params = new TreeMap<>();
        params.put("mobile", phone);
        subscription = ApiManager.setSubscribe(contactApi.getCode(params), new MySubscriber<BASE >() {
            @Override
            public void onNext(BASE ruslt) {

                mView.toEntity(ruslt,1);

            }

            @Override
            public void onError(Throwable e) {

                super.onError(e);
                mView.showTomast(e.getMessage());
            }
        });
    }
    public void checkCode(String mobile,String code,String pwd) {

        Map<String, String> params = new TreeMap<>();
        params.put("mobile", mobile);
        params.put("regCode", code);
        params.put("pwd", pwd);
        params.put("rePwd", pwd);
        subscription = ApiManager.setSubscribe(contactApi.checkCode(ApiManager.getParameters(params, true)), new MySubscriber<BASE>() {
            @Override
            public void onNext(BASE ruslt) {

                mView.toEntity(ruslt,2);

            }

            @Override
            public void onError(Throwable e) {

                super.onError(e);
                mView.showTomast(e.getMessage());
            }
        });
    }


    @Override
    public void getForgetPswCode(String phone) {

        Map<String, String> params = new TreeMap<>();
        subscription = ApiManager.setSubscribe(contactApi.getForgetPswCode(ApiManager.getParameters(params, true)), new MySubscriber<BASE >() {
            @Override
            public void onNext(BASE ruslt) {

                mView.toEntity(ruslt,1);

            }

            @Override
            public void onError(Throwable e) {

                super.onError(e);
                mView.showTomast(e.getMessage());
            }
        });
    }
    @Override
    public void updateBabyImg() {

        Map<String, String> params = new TreeMap<>();
        subscription = ApiManager.setSubscribe(contactApi.updateBabyImg(ApiManager.getParameters(params, true)), new MySubscriber<BASE >() {
            @Override
            public void onNext(BASE ruslt) {

                mView.toEntity(ruslt,0);

            }

            @Override
            public void onError(Throwable e) {

                super.onError(e);
                mView.showTomast(e.getMessage());
            }
        });
    }
    @Override
    public void logout() {

        Map<String, String> params = new TreeMap<>();
        subscription = ApiManager.setSubscribe(contactApi.logout(ApiManager.getParameters(params, true)), new MySubscriber<BASE >() {
            @Override
            public void onNext(BASE ruslt) {

                mView.toEntity(ruslt,6);

            }

            @Override
            public void onError(Throwable e) {

                super.onError(e);
                mView.showTomast(e.getMessage());
            }
        });
    }

    @Override
    public void attachView(@NonNull LoginContract.View view){
        mView = view;
    }


    @Override
    public void detachView(){
        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
        mView = null;
    }
}
