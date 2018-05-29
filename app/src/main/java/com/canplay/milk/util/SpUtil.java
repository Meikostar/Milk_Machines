package com.canplay.milk.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.canplay.milk.base.ApplicationConfig;
import com.canplay.milk.bean.USER;

public class SpUtil{
    public static String PREFERENCE_NAME = "repast_app_sp";

    private static SpUtil instance;
    public static final String LATITUDE="latitude";
    public static final String LONGITUDE="longitude";
    public static final String COMPANYID="company_id";
    public static final String PROVINCE="province";
    public static final String WEIGHT="weight";
    public static final String BIRTHDAY="birthday";
    public static final String CONTURY="contury";//国家
    public static final String TOKEN="access_token";//国家
    public static final String TOKEN_TYPE="token_type";//国家
    public static final String USERID="userId";//国家
    public static final String USERNAME="userName";//国家
    public static final String FATHERTNAME="fatherName";//国家
    public static final String PHONE="phone";//国家
    public static final String SEX="sex";//国家
    public static final String AVATOR="imgResourceKey";//国家
    public static final String MOTHERNAME="motherName";//国家
    private static SharedPreferences settings;
    public static String USER_ID="merchantId";

    private SpUtil() {
        settings = ApplicationConfig.context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }



    public boolean putUser(USER location) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(TOKEN, location.token+"");
        editor.putString(BIRTHDAY, location.birthday+"");
        editor.putString(USERID, location.userId);
        editor.putString(USERNAME, location.name);
        editor.putString(AVATOR, location.imgResourceKey);
        editor.putString(MOTHERNAME, location.motherName);
        editor.putString(FATHERTNAME, location.fatherName);
        editor.putString(PHONE, location.mobile);
        editor.putString(SEX, location.sex);
        editor.putString(WEIGHT, location.weight);
        return editor.commit();
    }


    /**
     * 返回单例对象
     *
     * @return SpUtil
     */
    public static SpUtil getInstance() {
        if (instance == null) {
            synchronized (SpUtil.class) {
                if (instance == null) {
                    instance = new SpUtil();
                }
            }
        }
        return instance;
    }
    public boolean clearData(){
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        return editor.commit();
    }

    public USER getUsers(){
        USER user = new USER();
        user.token=settings.getString(TOKEN, "");
        user.birthday=settings.getString(BIRTHDAY, "");
        user.userId=settings.getString(USERID, "");

        user.name=settings.getString(USERNAME, "");
        user.motherName=settings.getString(MOTHERNAME, "");
        user.fatherName=settings.getString(FATHERTNAME, "");
        user.mobile=settings.getString(PHONE, "");
        user.imgResourceKey=settings.getString(AVATOR, "");
        user.sex=settings.getString(SEX, "");
        user.weight=settings.getString(WEIGHT, "");
        return user;
    }
    public String getUserId(){
        return settings.getString(USERID, "");
    }
    public String getToken(){
        return settings.getString(TOKEN, "");
    }
    public String getTokenType(){
        return settings.getString(TOKEN_TYPE, "");
    }
    public String getUser(){
        return settings.getString(USERNAME, "");
    }
    public String getAvator(){
        return settings.getString(AVATOR, "");
    }

    /**
     * put string preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    public boolean putString(String key, String value) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * get string preferences
     *
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or null. Throws ClassCastException if there is a preference with this
     * name that is not a string
     * @see #getString(String, String)
     */
    public String getString(String key) {
        return getString(key, null);
    }

    /**
     * get string preferences
     *
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     * this name that is not a string
     */
    public String getString(String key, String defaultValue) {
        return settings.getString(key, defaultValue);
    }

    /**
     * put int preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    public boolean putInt(String key, int value) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * get int preferences
     *
     * @param
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
     * name that is not a int
     * @see #getInt(String, int)
     */
    public int getInt(String key) {
        return getInt(key, -1);
    }

    /**
     * get int preferences
     *
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     * this name that is not a int
     */
    public int getInt(String key, int defaultValue) {
        return settings.getInt(key, defaultValue);
    }

    /**
     * put long preferences
     *
     * @param key     The name of the preference to modify
     * @param value   The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    public boolean putLong(String key, long value) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    /**
     * get long preferences
     *
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
     * name that is not a long
     * @see #getLong(String, long)
     */
    public long getLong(String key) {
        return getLong(key, -1);
    }

    /**
     * get long preferences
     *
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     * this name that is not a long
     */
    public long getLong(String key, long defaultValue) {
        return settings.getLong(key, defaultValue);
    }

    /**
     * put float preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    public boolean putFloat(String key, float value) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    /**
     * get float preferences
     *
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
     * name that is not a float
     * @see #getFloat(String, float)
     */
    public float getFloat(String key) {
        return getFloat(key, -1);
    }

    /**
     * get float preferences
     *
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     * this name that is not a float
     */
    public float getFloat(String key, float defaultValue) {
        return settings.getFloat(key, defaultValue);
    }

    /**
     * put boolean preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    public boolean putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * get boolean preferences, default is false
     *
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or false. Throws ClassCastException if there is a preference with this
     * name that is not a boolean
     * @see #getBoolean(String, boolean)
     */
    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    /**
     * get boolean preferences
     *
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     * this name that is not a boolean
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        return settings.getBoolean(key, defaultValue);
    }
}

