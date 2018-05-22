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
    public void detachView(){
        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
        mView = null;
    }
}
