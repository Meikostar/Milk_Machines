// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.MCheckBox;
import com.canplay.milk.view.NavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WifiSettingActivity_ViewBinding implements Unbinder {
  private WifiSettingActivity target;

  @UiThread
  public WifiSettingActivity_ViewBinding(WifiSettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WifiSettingActivity_ViewBinding(WifiSettingActivity target, View source) {
    this.target = target;

    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.tvWifi = Utils.findRequiredViewAsType(source, R.id.tv_wifi, "field 'tvWifi'", TextView.class);
    target.ivWifi = Utils.findRequiredViewAsType(source, R.id.iv_wifi, "field 'ivWifi'", MCheckBox.class);
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    target.imageView3 = Utils.findRequiredViewAsType(source, R.id.imageView3, "field 'imageView3'", ImageView.class);
    target.tvNames = Utils.findRequiredViewAsType(source, R.id.tv_names, "field 'tvNames'", TextView.class);
    target.tvStatus = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'tvStatus'", TextView.class);
    target.tvEquptname = Utils.findRequiredViewAsType(source, R.id.tv_equptname, "field 'tvEquptname'", TextView.class);
    target.tvUser = Utils.findRequiredViewAsType(source, R.id.tv_user, "field 'tvUser'", TextView.class);
    target.tvLoginStatus = Utils.findRequiredViewAsType(source, R.id.tv_login_status, "field 'tvLoginStatus'", TextView.class);
    target.tvGet = Utils.findRequiredViewAsType(source, R.id.tv_get, "field 'tvGet'", TextView.class);
    target.tvSearch = Utils.findRequiredViewAsType(source, R.id.tv_search, "field 'tvSearch'", TextView.class);
    target.tvOpen = Utils.findRequiredViewAsType(source, R.id.tv_open, "field 'tvOpen'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WifiSettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigationBar = null;
    target.tvWifi = null;
    target.ivWifi = null;
    target.tvName = null;
    target.imageView3 = null;
    target.tvNames = null;
    target.tvStatus = null;
    target.tvEquptname = null;
    target.tvUser = null;
    target.tvLoginStatus = null;
    target.tvGet = null;
    target.tvSearch = null;
    target.tvOpen = null;
  }
}
