package com.canplay.milk.mvp.present;


import android.support.annotation.NonNull;


import com.canplay.milk.base.manager.ApiManager;
import com.canplay.milk.bean.BASE;
import com.canplay.milk.bean.WIPI;
import com.canplay.milk.mvp.http.BaseApi;
import com.canplay.milk.net.MySubscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;

import rx.Subscription;


public class BasesPresenter implements BaseContract.Presenter {
    private Subscription subscription;

    private BaseContract.View mView;

    private BaseApi contactApi;

    @Override
    public void attachView(@NonNull BaseContract.View view) {
        mView = view;
    }
    @Inject
    BasesPresenter(ApiManager apiManager){
        contactApi = apiManager.createApi(BaseApi.class);
    }
    @Override
    public void getArticleList(final int  type, String from, String take) {

        Map<String, String> params = new TreeMap<>();
        params.put("page",from);
        params.put("pageSize",take);
        subscription = ApiManager.setSubscribe(contactApi.getArticleList(ApiManager.getParameters(params, true)), new MySubscriber<WIPI>() {
            @Override
            public void onNext(WIPI ruslt) {

                mView.toEntity(ruslt,type);

            }

            @Override
            public void onError(Throwable e) {

                super.onError(e);
                mView.showTomast(e.getMessage());
            }
        });
    }

    public void SearchArticleList(final int  type, String from, String take,String content) {

        Map<String, String> params = new TreeMap<>();
        params.put("content",content);
        params.put("page",from);
        params.put("pageSize",take);
        subscription = ApiManager.setSubscribe(contactApi.getArticleList(ApiManager.getParameters(params, true)), new MySubscriber<WIPI>() {
            @Override
            public void onNext(WIPI ruslt) {

                mView.toEntity(ruslt,type);

            }

            @Override
            public void onError(Throwable e) {

                super.onError(e);
                mView.showTomast(e.getMessage());
            }
        });
    }
    @Override
    public void growRecordList(final int  type, String from, String take) {

        Map<String, String> params = new TreeMap<>();
        params.put("platformType","Android");
        params.put("page",from);
        params.put("pageSize",take);
        subscription = ApiManager.setSubscribe(contactApi.growRecordList(ApiManager.getParameters(params, true)), new MySubscriber<WIPI>() {
            @Override
            public void onNext(WIPI ruslt) {

                mView.toEntity(ruslt,type);

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mView.showTomast(e.getMessage());
            }
        });
    }
    @Override
    public void growRecordDetail( String id) {

        Map<String, String> params = new TreeMap<>();
        params.put("growRecordId",id);
        subscription = ApiManager.setSubscribe(contactApi.growRecordDetail(ApiManager.getParameters(params, true)), new MySubscriber<WIPI>() {
            @Override
            public void onNext(WIPI ruslt) {
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
    public void growRecordDelete( String id) {

        Map<String, String> params = new TreeMap<>();
        params.put("growRecordId",id);
        subscription = ApiManager.setSubscribe(contactApi.growRecordDelete(ApiManager.getParameters(params, true)), new MySubscriber<String>() {
            @Override
            public void onNext(String ruslt) {

                mView.toEntity(ruslt,8);

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mView.showTomast(e.getMessage());
            }
        });
    }

    @Override
    public void growRecordInsert(String url,String content) {

        Map<String, String> params = new TreeMap<>();
        params.put("content",content);
        params.put("imgResourceKeys",url);
        subscription = ApiManager.setSubscribe(contactApi.growRecordInsert(ApiManager.getParameters(params, true)), new MySubscriber<String>() {
            @Override
            public void onNext(String ruslt) {

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
    public void growRecordUpdate(String imgResourceKeys,String content,String growRecordId) {

        Map<String, String> params = new TreeMap<>();
        params.put("content",content);
        params.put("growRecordId",growRecordId);
        params.put("imgResourceKeys",imgResourceKeys);
        subscription = ApiManager.setSubscribe(contactApi.growRecordUpdate(ApiManager.getParameters(params, true)), new MySubscriber<String>() {
            @Override
            public void onNext(String ruslt) {

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
    public void detachView(){
        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
        mView = null;
    }
}
