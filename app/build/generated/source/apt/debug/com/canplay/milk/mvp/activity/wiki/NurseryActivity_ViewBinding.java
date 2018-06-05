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
import com.canplay.milk.view.NavigationBar;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NurseryActivity_ViewBinding implements Unbinder {
  private NurseryActivity target;

  @UiThread
  public NurseryActivity_ViewBinding(NurseryActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NurseryActivity_ViewBinding(NurseryActivity target, View source) {
    this.target = target;

    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.tvContent = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'tvContent'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
    target.llMy = Utils.findRequiredViewAsType(source, R.id.ll_my, "field 'llMy'", LinearLayout.class);
    target.mSuperRecyclerView = Utils.findRequiredViewAsType(source, R.id.super_recycle_view, "field 'mSuperRecyclerView'", SuperRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NurseryActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigationBar = null;
    target.tvContent = null;
    target.tvTime = null;
    target.llMy = null;
    target.mSuperRecyclerView = null;
  }
}
