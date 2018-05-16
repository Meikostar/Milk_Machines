// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PopView_NavigationBar_ViewBinding implements Unbinder {
  private PopView_NavigationBar target;

  @UiThread
  public PopView_NavigationBar_ViewBinding(PopView_NavigationBar target, View source) {
    this.target = target;

    target.llRing = Utils.findRequiredViewAsType(source, R.id.ll_ring, "field 'llRing'", LinearLayout.class);
    target.llWifi = Utils.findRequiredViewAsType(source, R.id.ll_wifi, "field 'llWifi'", LinearLayout.class);
    target.tvNew = Utils.findRequiredViewAsType(source, R.id.tv_new, "field 'tvNew'", TextView.class);
    target.llWater = Utils.findRequiredViewAsType(source, R.id.ll_water, "field 'llWater'", LinearLayout.class);
    target.llMilk = Utils.findRequiredViewAsType(source, R.id.ll_milk, "field 'llMilk'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PopView_NavigationBar target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.llRing = null;
    target.llWifi = null;
    target.tvNew = null;
    target.llWater = null;
    target.llMilk = null;
  }
}
