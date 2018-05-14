package com.canplay.milk.mvp.present;


import com.canplay.milk.base.BasePresenter;
import com.canplay.milk.base.BaseView;

public class LoginContract {
    public    interface View extends BaseView {

//        <T> void toList(List<T> list, int type, int... refreshType);
        <T> void toEntity(T entity,int type);

//        void toNextStep(int type);

        void showTomast(String msg);
    }

    public  interface Presenter extends BasePresenter<View> {

        /**
         * 获得联系人列表
         */
        void goLogin(String account, String pwd);


        /**
         * 下载
         */
        void  downApk();
        /**
         * 获取验证码
         */
        void getCode(String phone);

        /**
         * 忘记密码获取验证码
         */
        void getForgetPswCode(String phone);

        /**
         * 注册
         */
        void mobileRegister(String mobile, String regCode, String pwd,
                            String birthDate, String name, String sex, String weight);
        /**
         *  重置密码
         */
        void resetPwd(String mobile, String resetCode, String pwd);
        /**
         *  获取我的基本信息
         */
        void getMyBaseInfo();
        /**
         *  登出
         */
        void logout();
        /**
         *  更新头像
         */
        void updateBabyImg();

        /**
         * 检验验证码
         */
        void checkCode(String code);
    }
}
