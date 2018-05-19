// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SetFragment_ViewBinding implements Unbinder {
  private SetFragment target;

  @UiThread
  public SetFragment_ViewBinding(SetFragment target, View source) {
    this.target = target;

    target.line = Utils.findRequiredView(source, R.id.line, "field 'line'");
    target.ivImg = Utils.findRequiredViewAsType(source, R.id.iv_img, "field 'ivImg'", CircleImageView.class);
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    target.llWifi = Utils.findRequiredViewAsType(source, R.id.ll_wifi, "field 'llWifi'", LinearLayout.class);
    target.llAbout = Utils.findRequiredViewAsType(source, R.id.ll_about, "field 'llAbout'", LinearLayout.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.imageView, "field 'imageView'", ImageView.class);
    target.llPasw = Utils.findRequiredViewAsType(source, R.id.ll_pasw, "field 'llPasw'", LinearLayout.class);
    target.llUpdate = Utils.findRequiredViewAsType(source, R.id.ll_update, "field 'llUpdate'", LinearLayout.class);
    target.llChange = Utils.findRequiredViewAsType(source, R.id.ll_change, "field 'llChange'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SetFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.line = null;
    target.ivImg = null;
    target.tvName = null;
    target.llWifi = null;
    target.llAbout = null;
    target.imageView = null;
    target.llPasw = null;
    target.llUpdate = null;
    target.llChange = null;
  }
}
