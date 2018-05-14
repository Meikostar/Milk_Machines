package com.canplay.milk.mvp.present;


import android.support.annotation.NonNull;


import com.canplay.milk.base.manager.ApiManager;
import com.canplay.milk.mvp.http.BaseApi;

import java.util.ArrayList;
import java.util.List;

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




    @Override
    public void detachView(){
        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
        mView = null;
    }
}
