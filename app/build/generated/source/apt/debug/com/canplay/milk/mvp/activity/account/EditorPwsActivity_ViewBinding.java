// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.account;

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

public class EditorPwsActivity_ViewBinding implements Unbinder {
  private EditorPwsActivity target;

  @UiThread
  public EditorPwsActivity_ViewBinding(EditorPwsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EditorPwsActivity_ViewBinding(EditorPwsActivity target, View source) {
    this.target = target;

    target.navigationbar = Utils.findRequiredViewAsType(source, R.id.navigationbar, "field 'navigationbar'", NavigationBar.class);
    target.etPws = Utils.findRequiredViewAsType(source, R.id.et_pws, "field 'etPws'", ClearEditText.class);
    target.etPws1 = Utils.findRequiredViewAsType(source, R.id.et_pws1, "field 'etPws1'", ClearEditText.class);
    target.etPws2 = Utils.findRequiredViewAsType(source, R.id.et_pws2, "field 'etPws2'", ClearEditText.class);
    target.tvSure = Utils.findRequiredViewAsType(source, R.id.tv_sure, "field 'tvSure'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EditorPwsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigationbar = null;
    target.etPws = null;
    target.etPws1 = null;
    target.etPws2 = null;
    target.tvSure = null;
  }
}
