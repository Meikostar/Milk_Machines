// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  @UiThread
  public HomeFragment_ViewBinding(HomeFragment target, View source) {
    this.target = target;

    target.line = Utils.findRequiredView(source, R.id.line, "field 'line'");
    target.tvDate = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'tvDate'", TextView.class);
    target.ivImg = Utils.findRequiredViewAsType(source, R.id.iv_img, "field 'ivImg'", ImageView.class);
    target.tvMol = Utils.findRequiredViewAsType(source, R.id.tv_mol, "field 'tvMol'", TextView.class);
    target.tvDetail = Utils.findRequiredViewAsType(source, R.id.tv_detail, "field 'tvDetail'", TextView.class);
    target.tvZqx = Utils.findRequiredViewAsType(source, R.id.tv_zqx, "field 'tvZqx'", TextView.class);
    target.tvAdd = Utils.findRequiredViewAsType(source, R.id.tv_add, "field 'tvAdd'", TextView.class);
    target.tvMilk = Utils.findRequiredViewAsType(source, R.id.tv_milk, "field 'tvMilk'", TextView.class);
    target.tvChange = Utils.findRequiredViewAsType(source, R.id.tv_change, "field 'tvChange'", TextView.class);
    target.tvYm = Utils.findRequiredViewAsType(source, R.id.tv_ym, "field 'tvYm'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.line = null;
    target.tvDate = null;
    target.ivImg = null;
    target.tvMol = null;
    target.tvDetail = null;
    target.tvZqx = null;
    target.tvAdd = null;
    target.tvMilk = null;
    target.tvChange = null;
    target.tvYm = null;
    target.tvTime = null;
  }
}
