// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.adapter.recycle;

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

public class GroupRecordAdapter$ViewHolder_ViewBinding implements Unbinder {
  private GroupRecordAdapter.ViewHolder target;

  @UiThread
  public GroupRecordAdapter$ViewHolder_ViewBinding(GroupRecordAdapter.ViewHolder target, View source) {
    this.target = target;

    target.txtName = Utils.findRequiredViewAsType(source, R.id.txt_name, "field 'txtName'", TextView.class);
    target.txtDetail = Utils.findRequiredViewAsType(source, R.id.txt_detail, "field 'txtDetail'", TextView.class);
    target.ivImg1 = Utils.findRequiredViewAsType(source, R.id.iv_img1, "field 'ivImg1'", ImageView.class);
    target.ivImg2 = Utils.findRequiredViewAsType(source, R.id.iv_img2, "field 'ivImg2'", ImageView.class);
    target.ivImg3 = Utils.findRequiredViewAsType(source, R.id.iv_img3, "field 'ivImg3'", ImageView.class);
    target.llbg = Utils.findRequiredViewAsType(source, R.id.ll_bg, "field 'llbg'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GroupRecordAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtName = null;
    target.txtDetail = null;
    target.ivImg1 = null;
    target.ivImg2 = null;
    target.ivImg3 = null;
    target.llbg = null;
  }
}
