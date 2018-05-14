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
import java.lang.IllegalStateException;
import java.lang.Override;

public class WikiPediaFragment_ViewBinding implements Unbinder {
  private WikiPediaFragment target;

  @UiThread
  public WikiPediaFragment_ViewBinding(WikiPediaFragment target, View source) {
    this.target = target;

    target.line = Utils.findRequiredView(source, R.id.line, "field 'line'");
    target.tvYm = Utils.findRequiredViewAsType(source, R.id.tv_ym, "field 'tvYm'", TextView.class);
    target.llGroup = Utils.findRequiredViewAsType(source, R.id.ll_group, "field 'llGroup'", LinearLayout.class);
    target.bai3 = Utils.findRequiredViewAsType(source, R.id.bai3, "field 'bai3'", ImageView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ivFirst = Utils.findRequiredViewAsType(source, R.id.iv_first, "field 'ivFirst'", ImageView.class);
    target.llPast = Utils.findRequiredViewAsType(source, R.id.ll_past, "field 'llPast'", LinearLayout.class);
    target.llPass = Utils.findRequiredViewAsType(source, R.id.ll_pass, "field 'llPass'", LinearLayout.class);
    target.llTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'llTime'", LinearLayout.class);
    target.llRecord = Utils.findRequiredViewAsType(source, R.id.ll_record, "field 'llRecord'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WikiPediaFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.line = null;
    target.tvYm = null;
    target.llGroup = null;
    target.bai3 = null;
    target.tvTitle = null;
    target.ivFirst = null;
    target.llPast = null;
    target.llPass = null;
    target.llTime = null;
    target.llRecord = null;
  }
}
