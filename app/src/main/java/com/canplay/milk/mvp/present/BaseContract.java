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
        /**
         * 获取百科列表
         * @param type
         * @param from
         * @param take
         */
        void getArticleList(final int  type, String from, String take);

        /**
         * 上传成长记录
         * @param url
         * @param content
         */
        void growRecordInsert(String url,String content);

        /**
         * 成长记录
         */
        void growRecordList();
    }
}
