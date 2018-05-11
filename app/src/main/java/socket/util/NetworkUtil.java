package socket.util;

import android.content.Context;
import android.net.ConnectivityManager;

import com.mykar.framework.ApplicationHolder;

/**
 * Created by neal on 2014/12/2.
 */
public class NetworkUtil {
    public static boolean isNetworkConnect(){
        if(ApplicationHolder.getmApplication()==null){
            return false;
        }
        ConnectivityManager connectivityManager= (ConnectivityManager)ApplicationHolder.getmApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager!=null) {
            if(connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isConnected()){
                return true;
            }
        }
        return false;
    }
}
