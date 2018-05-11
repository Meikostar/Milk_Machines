// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.account;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.NavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ForgetPswActivity_ViewBinding implements Unbinder {
  private ForgetPswActivity target;

  @UiThread
  public ForgetPswActivity_ViewBinding(ForgetPswActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ForgetPswActivity_ViewBinding(ForgetPswActivity target, View source) {
    this.target = target;

    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.etPhone = Utils.findRequiredViewAsType(source, R.id.et_phone, "field 'etPhone'", ClearEditText.class);
    target.tvGetcode = Utils.findRequiredViewAsType(source, R.id.tv_getcode, "field 'tvGetcode'", TextView.class);
    target.etPass = Utils.findRequiredViewAsType(source, R.id.et_pass, "field 'etPass'", ClearEditText.class);
    target.ivCheck1 = Utils.findRequiredViewAsType(source, R.id.iv_check1, "field 'ivCheck1'", ImageView.class);
    target.etUser = Utils.findRequiredViewAsType(source, R.id.et_user, "field 'etUser'", ClearEditText.class);
    target.ivCheck2 = Utils.findRequiredViewAsType(source, R.id.iv_check2, "field 'ivCheck2'", ImageView.class);
    target.etConfirm = Utils.findRequiredViewAsType(source, R.id.et_confirm, "field 'etConfirm'", ClearEditText.class);
    target.ivCheck3 = Utils.findRequiredViewAsType(source, R.id.iv_check3, "field 'ivCheck3'", ImageView.class);
    target.tvHint = Utils.findRequiredViewAsType(source, R.id.tv_hint, "field 'tvHint'", TextView.class);
    target.tvNext = Utils.findRequiredViewAsType(source, R.id.tv_next, "field 'tvNext'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ForgetPswActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigationBar = null;
    target.etPhone = null;
    target.tvGetcode = null;
    target.etPass = null;
    target.ivCheck1 = null;
    target.etUser = null;
    target.ivCheck2 = null;
    target.etConfirm = null;
    target.ivCheck3 = null;
    target.tvHint = null;
    target.tvNext = null;
  }
}
