// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.wiki;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.NavigationBar;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PastWipiActivity_ViewBinding implements Unbinder {
  private PastWipiActivity target;

  @UiThread
  public PastWipiActivity_ViewBinding(PastWipiActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PastWipiActivity_ViewBinding(PastWipiActivity target, View source) {
    this.target = target;

    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.etSearch = Utils.findRequiredViewAsType(source, R.id.et_search, "field 'etSearch'", ClearEditText.class);
    target.ivSearch = Utils.findRequiredViewAsType(source, R.id.iv_search, "field 'ivSearch'", ImageView.class);
    target.mSuperRecyclerView = Utils.findRequiredViewAsType(source, R.id.super_recycle_view, "field 'mSuperRecyclerView'", SuperRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PastWipiActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigationBar = null;
    target.etSearch = null;
    target.ivSearch = null;
    target.mSuperRecyclerView = null;
  }
}
