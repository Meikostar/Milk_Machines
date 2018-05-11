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
import com.canplay.milk.view.MCheckBox;
import com.canplay.milk.view.NavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisteredThreeActivity_ViewBinding implements Unbinder {
  private RegisteredThreeActivity target;

  @UiThread
  public RegisteredThreeActivity_ViewBinding(RegisteredThreeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisteredThreeActivity_ViewBinding(RegisteredThreeActivity target, View source) {
    this.target = target;

    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.etPhone = Utils.findRequiredViewAsType(source, R.id.et_phone, "field 'etPhone'", ClearEditText.class);
    target.etCode = Utils.findRequiredViewAsType(source, R.id.et_code, "field 'etCode'", ClearEditText.class);
    target.tvGetcode = Utils.findRequiredViewAsType(source, R.id.tv_getcode, "field 'tvGetcode'", TextView.class);
    target.etPass = Utils.findRequiredViewAsType(source, R.id.et_pass, "field 'etPass'", ClearEditText.class);
    target.etUser = Utils.findRequiredViewAsType(source, R.id.et_user, "field 'etUser'", ClearEditText.class);
    target.ivChoose = Utils.findRequiredViewAsType(source, R.id.iv_choose, "field 'ivChoose'", MCheckBox.class);
    target.tvRegistered = Utils.findRequiredViewAsType(source, R.id.tv_registered, "field 'tvRegistered'", TextView.class);
    target.tvSave = Utils.findRequiredViewAsType(source, R.id.tv_next, "field 'tvSave'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisteredThreeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigationBar = null;
    target.etPhone = null;
    target.etCode = null;
    target.tvGetcode = null;
    target.etPass = null;
    target.etUser = null;
    target.ivChoose = null;
    target.tvRegistered = null;
    target.tvSave = null;
  }
}
