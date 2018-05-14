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

public class DataCyeleAdapter$ViewHolder_ViewBinding implements Unbinder {
  private DataCyeleAdapter.ViewHolder target;

  @UiThread
  public DataCyeleAdapter$ViewHolder_ViewBinding(DataCyeleAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvOne = Utils.findRequiredViewAsType(source, R.id.tv_one, "field 'tvOne'", TextView.class);
    target.tvTwo = Utils.findRequiredViewAsType(source, R.id.tv_two, "field 'tvTwo'", TextView.class);
    target.tvThree = Utils.findRequiredViewAsType(source, R.id.tv_three, "field 'tvThree'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DataCyeleAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvOne = null;
    target.tvTwo = null;
    target.tvThree = null;
  }
}
