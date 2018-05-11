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
import com.canplay.milk.view.NavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserAvarActivity_ViewBinding implements Unbinder {
  private UserAvarActivity target;

  @UiThread
  public UserAvarActivity_ViewBinding(UserAvarActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserAvarActivity_ViewBinding(UserAvarActivity target, View source) {
    this.target = target;

    target.line = Utils.findRequiredView(source, R.id.line, "field 'line'");
    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.tvChoose = Utils.findRequiredViewAsType(source, R.id.tv_choose, "field 'tvChoose'", TextView.class);
    target.tvLocal = Utils.findRequiredViewAsType(source, R.id.tv_local, "field 'tvLocal'", TextView.class);
    target.ivImg = Utils.findRequiredViewAsType(source, R.id.iv_img, "field 'ivImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserAvarActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.line = null;
    target.navigationBar = null;
    target.tvChoose = null;
    target.tvLocal = null;
    target.ivImg = null;
  }
}
