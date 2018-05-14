// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.NavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateActivity_ViewBinding implements Unbinder {
  private UpdateActivity target;

  @UiThread
  public UpdateActivity_ViewBinding(UpdateActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdateActivity_ViewBinding(UpdateActivity target, View source) {
    this.target = target;

    target.line = Utils.findRequiredView(source, R.id.line, "field 'line'");
    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.tvVersion = Utils.findRequiredViewAsType(source, R.id.tv_version, "field 'tvVersion'", TextView.class);
    target.tvUpdate = Utils.findRequiredViewAsType(source, R.id.tv_update, "field 'tvUpdate'", TextView.class);
    target.tvContent = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'tvContent'", TextView.class);
    target.llUpdate = Utils.findRequiredViewAsType(source, R.id.ll_update, "field 'llUpdate'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UpdateActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.line = null;
    target.navigationBar = null;
    target.tvVersion = null;
    target.tvUpdate = null;
    target.tvContent = null;
    target.llUpdate = null;
  }
}
