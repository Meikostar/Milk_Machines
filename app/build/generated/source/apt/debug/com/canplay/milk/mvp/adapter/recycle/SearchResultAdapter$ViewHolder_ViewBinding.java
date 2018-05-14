// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.adapter.recycle;

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

public class SearchResultAdapter$ViewHolder_ViewBinding implements Unbinder {
  private SearchResultAdapter.ViewHolder target;

  @UiThread
  public SearchResultAdapter$ViewHolder_ViewBinding(SearchResultAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ivImg = Utils.findRequiredViewAsType(source, R.id.iv_img, "field 'ivImg'", ImageView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
    target.tvContent = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'tvContent'", TextView.class);
    target.tvGoDetail = Utils.findRequiredViewAsType(source, R.id.tv_go_detail, "field 'tvGoDetail'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchResultAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTitle = null;
    target.ivImg = null;
    target.tvTime = null;
    target.tvContent = null;
    target.tvGoDetail = null;
  }
}
