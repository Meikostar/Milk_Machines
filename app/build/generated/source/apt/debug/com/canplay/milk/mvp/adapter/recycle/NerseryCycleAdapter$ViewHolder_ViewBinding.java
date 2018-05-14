// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.adapter.recycle;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NerseryCycleAdapter$ViewHolder_ViewBinding implements Unbinder {
  private NerseryCycleAdapter.ViewHolder target;

  @UiThread
  public NerseryCycleAdapter$ViewHolder_ViewBinding(NerseryCycleAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NerseryCycleAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvName = null;
    target.tvTime = null;
  }
}
