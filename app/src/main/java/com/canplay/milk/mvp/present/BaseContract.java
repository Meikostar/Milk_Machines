package com.canplay.milk.mvp.present;

import com.canplay.milk.base.BasePresenter;
import com.canplay.milk.base.BaseView;

public class BaseContract {
    public    interface View extends BaseView {

//        <T> void toList(List<T> list, int type, int... refreshType);
        <T> void toEntity(T entity, int type);

        void toNextStep(int type);

        void showTomast(String msg);
    }

    public  interface Presenter extends BasePresenter<View> {

    }
}
