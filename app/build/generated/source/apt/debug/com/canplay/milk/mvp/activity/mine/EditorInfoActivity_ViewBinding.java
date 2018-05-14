// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.NavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditorInfoActivity_ViewBinding implements Unbinder {
  private EditorInfoActivity target;

  @UiThread
  public EditorInfoActivity_ViewBinding(EditorInfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EditorInfoActivity_ViewBinding(EditorInfoActivity target, View source) {
    this.target = target;

    target.line = Utils.findRequiredView(source, R.id.line, "field 'line'");
    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.etName = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'etName'", ClearEditText.class);
    target.etBaby = Utils.findRequiredViewAsType(source, R.id.et_baby, "field 'etBaby'", ClearEditText.class);
    target.tvDate = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'tvDate'", TextView.class);
    target.tvAdd = Utils.findRequiredViewAsType(source, R.id.tv_add, "field 'tvAdd'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EditorInfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.line = null;
    target.navigationBar = null;
    target.etName = null;
    target.etBaby = null;
    target.tvDate = null;
    target.tvAdd = null;
  }
}
