package com.canplay.milk.mvp.http;



import com.canplay.milk.bean.BASE;
import com.canplay.milk.bean.USER;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;


public interface BaseApi {


    /**
     * Login
     * @param options
     * @return
     */


    @FormUrlEncoded
    @POST("web/mobileLogin")
    Observable<USER> Login(@FieldMap Map<String, String> options);

    /**
     * 重置密码
     * @param options
     * @return
     */
    @FormUrlEncoded
    @POST("web/resetPwd")
    Observable<USER> resetPwd(@FieldMap Map<String, String> options);

    /**
     * 下載apk
     * @param options
     * @return
     */
    @FormUrlEncoded
    @POST("Flow/Token")
    Observable<BASE> downApk(@FieldMap Map<String, String> options);
    /**
     * 获取验证码
     * @param options
     * @return
     */
    @FormUrlEncoded
    @POST("web/getRegisterCode")
    Observable<BASE> getCode(@FieldMap Map<String, String> options);

    /**
     * 校验验证码
     * @param options
     * @return
     */
    @FormUrlEncoded
    @POST("web/getRegisterCode")
    Observable<BASE> checkCode(@FieldMap Map<String, String> options);
    /**
     * 重置密码
     * @param options
     * @return
     */
    @FormUrlEncoded
    @POST("web/getResetCode")
    Observable<BASE> getForgetPswCode(@FieldMap Map<String, String> options);

    /**
     * 登出
     * @param options
     * @return
     */
    @FormUrlEncoded
    @POST("web/logout")
    Observable<BASE> logout(@FieldMap Map<String, String> options);

    /**
     * 更新头像
     * @param options
     * @return
     */
    @FormUrlEncoded
    @POST("web/updateBabyImg")
    Observable<BASE> updateBabyImg(@FieldMap Map<String, String> options);
    /**
     *  手机注册
     * @param options
     * @return
     */
    @FormUrlEncoded
    @POST("web/getMyBaseInfo")
    Observable<USER> mobileRegister(@FieldMap Map<String, String> options);

    /**
     *  手机注册
     * @param options
     * @return
     */
    @FormUrlEncoded
    @POST("web/updateMyBaseInfo")
    Observable<USER> updateMyBaseInfo(@FieldMap Map<String, String> options);

    /**
     * 获取我的基本信息
     * @param options
     * @return
     */
    @FormUrlEncoded
    @POST("web/getMyBaseInfo")
    Observable<USER> getMyBaseInfo(@FieldMap Map<String, String> options);





    /**
     * 获取验证码
     */
    @POST("Flow/v2/VerifyMobileNumber/{name}")
    Observable<String> getCode(@Path("name") String name);


}
