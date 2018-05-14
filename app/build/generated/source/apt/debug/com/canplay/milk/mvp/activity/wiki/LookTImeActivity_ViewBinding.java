// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.wiki;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.MCheckBox;
import com.canplay.milk.view.NavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LookTImeActivity_ViewBinding implements Unbinder {
  private LookTImeActivity target;

  @UiThread
  public LookTImeActivity_ViewBinding(LookTImeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LookTImeActivity_ViewBinding(LookTImeActivity target, View source) {
    this.target = target;

    target.line = Utils.findRequiredView(source, R.id.line, "field 'line'");
    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.tvContent = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'tvContent'", TextView.class);
    target.tvPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhone'", TextView.class);
    target.llMy = Utils.findRequiredViewAsType(source, R.id.ll_my, "field 'llMy'", LinearLayout.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
    target.llTime = Utils.findRequiredViewAsType(source, R.id.ll_time, "field 'llTime'", LinearLayout.class);
    target.tvTime2 = Utils.findRequiredViewAsType(source, R.id.tv_time2, "field 'tvTime2'", TextView.class);
    target.llTime2 = Utils.findRequiredViewAsType(source, R.id.ll_time2, "field 'llTime2'", LinearLayout.class);
    target.tvNow = Utils.findRequiredViewAsType(source, R.id.tv_now, "field 'tvNow'", TextView.class);
    target.llNow = Utils.findRequiredViewAsType(source, R.id.ll_now, "field 'llNow'", LinearLayout.class);
    target.tvDay = Utils.findRequiredViewAsType(source, R.id.tv_day, "field 'tvDay'", TextView.class);
    target.ivWifi = Utils.findRequiredViewAsType(source, R.id.iv_wifi, "field 'ivWifi'", MCheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LookTImeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.line = null;
    target.navigationBar = null;
    target.tvContent = null;
    target.tvPhone = null;
    target.llMy = null;
    target.tvTime = null;
    target.llTime = null;
    target.tvTime2 = null;
    target.llTime2 = null;
    target.tvNow = null;
    target.llNow = null;
    target.tvDay = null;
    target.ivWifi = null;
  }
}
