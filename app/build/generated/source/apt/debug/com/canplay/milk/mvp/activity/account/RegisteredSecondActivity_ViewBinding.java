// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.account;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.NavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisteredSecondActivity_ViewBinding implements Unbinder {
  private RegisteredSecondActivity target;

  @UiThread
  public RegisteredSecondActivity_ViewBinding(RegisteredSecondActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisteredSecondActivity_ViewBinding(RegisteredSecondActivity target, View source) {
    this.target = target;

    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.etName = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'etName'", ClearEditText.class);
    target.tvChoose = Utils.findRequiredViewAsType(source, R.id.tv_choose, "field 'tvChoose'", TextView.class);
    target.tvSex = Utils.findRequiredViewAsType(source, R.id.tv_sex, "field 'tvSex'", TextView.class);
    target.llSex = Utils.findRequiredViewAsType(source, R.id.ll_sex, "field 'llSex'", LinearLayout.class);
    target.etDate = Utils.findRequiredViewAsType(source, R.id.et_date, "field 'etDate'", ClearEditText.class);
    target.etWeight = Utils.findRequiredViewAsType(source, R.id.et_weight, "field 'etWeight'", ClearEditText.class);
    target.tvRegistered = Utils.findRequiredViewAsType(source, R.id.tv_registered, "field 'tvRegistered'", TextView.class);
    target.tvNext = Utils.findRequiredViewAsType(source, R.id.tv_next, "field 'tvNext'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisteredSecondActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigationBar = null;
    target.etName = null;
    target.tvChoose = null;
    target.tvSex = null;
    target.llSex = null;
    target.etDate = null;
    target.etWeight = null;
    target.tvRegistered = null;
    target.tvNext = null;
  }
}
