// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.NavigationBar;
import com.canplay.milk.view.NoScrollViewPager;
import com.canplay.milk.view.ThreeNevgBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DevelopActivity_ViewBinding implements Unbinder {
  private DevelopActivity target;

  @UiThread
  public DevelopActivity_ViewBinding(DevelopActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DevelopActivity_ViewBinding(DevelopActivity target, View source) {
    this.target = target;

    target.line = Utils.findRequiredView(source, R.id.line, "field 'line'");
    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.tvData = Utils.findRequiredViewAsType(source, R.id.tv_data, "field 'tvData'", TextView.class);
    target.viewpagerMain = Utils.findRequiredViewAsType(source, R.id.viewpager_main, "field 'viewpagerMain'", NoScrollViewPager.class);
    target.neBar = Utils.findRequiredViewAsType(source, R.id.ne_bar, "field 'neBar'", ThreeNevgBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DevelopActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.line = null;
    target.navigationBar = null;
    target.tvData = null;
    target.viewpagerMain = null;
    target.neBar = null;
  }
}
