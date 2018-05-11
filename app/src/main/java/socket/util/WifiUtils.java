package socket.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import com.canplay.milk.base.BaseApplication;
import com.mykar.framework.ApplicationHolder;

import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Created by linquandong on 15/8/22.
 */
public class WifiUtils {
    private final ConnectivityManager connectivityManager;
    public WifiManager mWifiManager;
    public WifiInfo mWifiInfo;

    private static final String DEYI_WIFI = "laserwifi";

    private WifiUtils() {
        mWifiManager = (WifiManager) BaseApplication.getInstance().getSystemService(Context.WIFI_SERVICE);
        connectivityManager = (ConnectivityManager) BaseApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);

        mWifiInfo = mWifiManager.getConnectionInfo();
    }

    private static WifiUtils mWifiUtils;

    public static WifiUtils shareInstance() {
        if (mWifiUtils == null) {
            //取得WifiInfo对象
            return new WifiUtils();
        }
        return mWifiUtils;
    }

    //打开wifi
    public void openWifi() {
        if (!mWifiManager.isWifiEnabled()) {
            mWifiManager.setWifiEnabled(true);
        }
    }

    //关闭wifi
    public void closeWifi() {
        if (!mWifiManager.isWifiEnabled()) {
            mWifiManager.setWifiEnabled(false);
        }
    }

    //得到wifiInfo的所有信息
    public String getWifiInfo() {
        return (mWifiInfo == null) ? "" : mWifiInfo.toString();
    }

    public String getBSSID() {
        return (mWifiInfo == null) ? "" : mWifiInfo.getBSSID();
    }

    public String getWifiName() {
        return (mWifiInfo == null) ? "" : mWifiInfo.getSSID();
    }

    public int getIpAddress() {
        return (mWifiInfo == null) ? 0 : mWifiInfo.getIpAddress();
    }

    public String getLocalIpAddress() {
        try {
            return int2ip(getIpAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 将ip的整数形式转换成ip形式
     *
     * @param ipInt
     * @return
     */
    public String int2ip(int ipInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipInt & 0xFF).append(".");
        sb.append((ipInt >> 8) & 0xFF).append(".");
        sb.append((ipInt >> 16) & 0xFF).append(".");
        sb.append((ipInt >> 24) & 0xFF);
        return sb.toString();
    }

    public String getMacAddress() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iF = interfaces.nextElement();
                byte[] addr = iF.getHardwareAddress();
                if (addr == null || addr.length == 0) {
                    continue;
                }
                StringBuilder buf = new StringBuilder();
                for (byte b : addr) {
                    buf.append(String.format("%02X:", b));
                }
                if (buf.length() > 0) {
                    buf.deleteCharAt(buf.length() - 1);
                }
                return buf.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return mWifiInfo.getMacAddress();
    }

    public String getWifiPwd() {
        SharedPreferences sharedPreferences = ApplicationHolder.getmApplication().getSharedPreferences(DEYI_WIFI, 0);
        return sharedPreferences.getString(getBSSID(), "");
    }

    public void saveWifiPwd(String pwd) {
        SharedPreferences sharedPreferences = ApplicationHolder.getmApplication().getSharedPreferences(DEYI_WIFI, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getBSSID(), pwd);
        editor.commit();
    }

    public boolean isUseable() {
       NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if(info != null && info.isAvailable()) {
            return true;
        }else{
            return false;
        }
    }

    public boolean isWifi(){
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if(info != null && info.isAvailable()) {
            String name = info.getTypeName();
            if(name.equals("WIFI")) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
