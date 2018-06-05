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
       void growRecordList(final int  type, String from, String take);


        /**
         * 跟新成长记录
         */
        void growRecordUpdate(String imgResourceKeys,String content,String growRecordId);


        /**
         * 搜索文章
         */
        void SearchArticleList(final int  type, String from, String take,String content);


        /**
         * 记录详情
         */
        void growRecordDetail( String id);

        /**
         * 删除记录
         */
        void growRecordDelete( String id);
        /**
         * 疫苗助手列表
         */
        void getUserVaccineList();
        /**
         * 上报奶量
         */
        void insertUserMilkRecord(String waterQuantity);
        /**
         * 三日喂奶记录
         */
        void getUserMilkRecord();
        /**
         * 获取冲奶设置
         */
        void getUserMilkConf();
        /**
         * 设置冲奶设置
         */
        void setUserMilkConf(String consistence ,String waterQuantity	,String waterTemperature);
    }
}
