// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.account;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.NavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ForgetFirstActivity_ViewBinding implements Unbinder {
  private ForgetFirstActivity target;

  @UiThread
  public ForgetFirstActivity_ViewBinding(ForgetFirstActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ForgetFirstActivity_ViewBinding(ForgetFirstActivity target, View source) {
    this.target = target;

    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.tvRegistered = Utils.findRequiredViewAsType(source, R.id.tv_registered, "field 'tvRegistered'", TextView.class);
    target.tvNext = Utils.findRequiredViewAsType(source, R.id.tv_next, "field 'tvNext'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ForgetFirstActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigationBar = null;
    target.tvRegistered = null;
    target.tvNext = null;
  }
}
