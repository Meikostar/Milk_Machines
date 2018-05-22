package com.canplay.milk.mvp.http;



import com.canplay.milk.bean.BASE;
import com.canplay.milk.bean.USER;
import com.canplay.milk.bean.WIPI;

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


    @POST("web/mobileLogin")
    Observable<USER> Login(@QueryMap Map<String, String> options);


    /**
     * Login
     * @param options
     * @return
     */


    @POST("web/getLastestVersion")
    Observable<BASE> getLastestVersion(@QueryMap Map<String, String> options);


    /**
     * 重置密码
     * @param options
     * @return
     */

    @POST("web/resetPwd")
    Observable<USER> resetPwd(@QueryMap Map<String, String> options);

    /**
     * 下載apk
     * @param options
     * @return
     */
    @POST("Flow/Token")
    Observable<BASE> downApk(@QueryMap Map<String, String> options);
    /**
     * 获取验证码
     * @param options
     * @return
     */

    @POST("web/getRegisterCode")
    Observable<BASE> getCode(@QueryMap Map<String, String> options);

    /**
     * 校验验证码
     * @param options
     * @return
     */

    @POST("web/validateRegisterCode")
    Observable<BASE> checkCode(@QueryMap Map<String, String> options);
    /**
     * 重置密码
     * @param options
     * @return
     */

    @POST("web/getResetCode")
    Observable<BASE> getForgetPswCode(@QueryMap Map<String, String> options);

    /**
     * 登出
     * @param options
     * @return
     */

    @POST("web/logout")
    Observable<BASE> logout(@QueryMap Map<String, String> options);

    /**
     * 登出
     * @param options
     * @return
     */

    @POST("web/getArticleList")
    Observable<WIPI> getArticleList(@QueryMap Map<String, String> options);


    /**
     * 更新头像
     * @param options
     * @return
     */

    @POST("web/updateBabyImg")
    Observable<BASE> updateBabyImg(@QueryMap Map<String, Object> options);
    /**
     * 更新头像
     * @param options
     * @return
     */

    @POST("web/growRecordImgUpload")
    Observable<BASE> growRecordImgUpload(@QueryMap Map<String, Object> options);

    /**
     *  手机注册
     * @param options
     * @return
     */

    @POST("web/mobileRegister")
    Observable<USER> mobileRegister(@QueryMap Map<String, String> options);

    /**
     *  更新用户信息
     * @param options
     * @return
     */

    @POST("web/updateMyBaseInfo")
    Observable<USER> updateMyBaseInfo(@QueryMap Map<String, String> options);

    /**
     * 获取我的基本信息
     * @param options
     * @return
     */

    @POST("web/getMyBaseInfo")
    Observable<USER> getMyBaseInfo(@QueryMap Map<String, String> options);





    /**
     * 获取验证码
     */
    @POST("Flow/v2/VerifyMobileNumber/{name}")
    Observable<String> getCode(@Path("name") String name);


}
