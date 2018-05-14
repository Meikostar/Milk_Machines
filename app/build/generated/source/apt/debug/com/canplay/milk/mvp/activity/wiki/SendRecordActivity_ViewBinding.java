// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.mvp.activity.wiki;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.ImageUploadView;
import com.canplay.milk.view.NavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SendRecordActivity_ViewBinding implements Unbinder {
  private SendRecordActivity target;

  @UiThread
  public SendRecordActivity_ViewBinding(SendRecordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SendRecordActivity_ViewBinding(SendRecordActivity target, View source) {
    this.target = target;

    target.navigationBar = Utils.findRequiredViewAsType(source, R.id.navigationBar, "field 'navigationBar'", NavigationBar.class);
    target.etContent = Utils.findRequiredViewAsType(source, R.id.et_content, "field 'etContent'", ClearEditText.class);
    target.ivAddPhoto = Utils.findRequiredViewAsType(source, R.id.iv_add_photo, "field 'ivAddPhoto'", TextView.class);
    target.piuvRemarkImage = Utils.findRequiredViewAsType(source, R.id.piuv_remark_image, "field 'piuvRemarkImage'", ImageUploadView.class);
    target.txtTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'txtTime'", TextView.class);
    target.llBottomButton = Utils.findRequiredView(source, R.id.ll_bottom_button, "field 'llBottomButton'");
  }

  @Override
  @CallSuper
  public void unbind() {
    SendRecordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigationBar = null;
    target.etContent = null;
    target.ivAddPhoto = null;
    target.piuvRemarkImage = null;
    target.txtTime = null;
    target.llBottomButton = null;
  }
}
