// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.NavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineInfoActivity_ViewBinding implements Unbinder {
  private MineInfoActivity target;

  @UiThread
  public MineInfoActivity_ViewBinding(MineInfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MineInfoActivity_ViewBinding(MineInfoActivity target, View source) {
    this.target = target;

    target.line = Utils.findRequiredView(source, R.id.line, "field 'line'");
    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.ivImgs = Utils.findRequiredViewAsType(source, R.id.iv_imgs, "field 'ivImgs'", ImageView.class);
    target.etBaby = Utils.findRequiredViewAsType(source, R.id.et_baby, "field 'etBaby'", ClearEditText.class);
    target.etFather = Utils.findRequiredViewAsType(source, R.id.et_father, "field 'etFather'", ClearEditText.class);
    target.etMami = Utils.findRequiredViewAsType(source, R.id.et_mami, "field 'etMami'", ClearEditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MineInfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.line = null;
    target.navigationBar = null;
    target.ivImgs = null;
    target.etBaby = null;
    target.etFather = null;
    target.etMami = null;
  }
}
