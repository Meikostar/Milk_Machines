// Generated code from Butter Knife. Do not modify!
package com.canplay.milk.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.canplay.medical.R;
import com.canplay.milk.view.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FileFragment_ViewBinding implements Unbinder {
  private FileFragment target;

  @UiThread
  public FileFragment_ViewBinding(FileFragment target, View source) {
    this.target = target;

    target.line = Utils.findRequiredView(source, R.id.line, "field 'line'");
    target.tvBirth = Utils.findRequiredViewAsType(source, R.id.tv_birth, "field 'tvBirth'", TextView.class);
    target.tvSex = Utils.findRequiredViewAsType(source, R.id.tv_sex, "field 'tvSex'", TextView.class);
    target.ivImgs = Utils.findRequiredViewAsType(source, R.id.iv_imgs, "field 'ivImgs'", CircleImageView.class);
    target.tvNick = Utils.findRequiredViewAsType(source, R.id.tv_nick, "field 'tvNick'", TextView.class);
    target.tvWeigh = Utils.findRequiredViewAsType(source, R.id.tv_weigh, "field 'tvWeigh'", TextView.class);
    target.llEditor = Utils.findRequiredViewAsType(source, R.id.ll_editor, "field 'llEditor'", LinearLayout.class);
    target.imageView2 = Utils.findRequiredViewAsType(source, R.id.imageView2, "field 'imageView2'", ImageView.class);
    target.llExpend = Utils.findRequiredViewAsType(source, R.id.ll_expend, "field 'llExpend'", LinearLayout.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvText1 = Utils.findRequiredViewAsType(source, R.id.tv_text1, "field 'tvText1'", TextView.class);
    target.tvText2 = Utils.findRequiredViewAsType(source, R.id.tv_text2, "field 'tvText2'", TextView.class);
    target.tvText3 = Utils.findRequiredViewAsType(source, R.id.tv_text3, "field 'tvText3'", TextView.class);
    target.tvText4 = Utils.findRequiredViewAsType(source, R.id.tv_text4, "field 'tvText4'", TextView.class);
    target.tvText5 = Utils.findRequiredViewAsType(source, R.id.tv_text5, "field 'tvText5'", TextView.class);
    target.tvText6 = Utils.findRequiredViewAsType(source, R.id.tv_text6, "field 'tvText6'", TextView.class);
    target.tvText7 = Utils.findRequiredViewAsType(source, R.id.tv_text7, "field 'tvText7'", TextView.class);
    target.tvText8 = Utils.findRequiredViewAsType(source, R.id.tv_text8, "field 'tvText8'", TextView.class);
    target.tvText9 = Utils.findRequiredViewAsType(source, R.id.tv_text9, "field 'tvText9'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FileFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.line = null;
    target.tvBirth = null;
    target.tvSex = null;
    target.ivImgs = null;
    target.tvNick = null;
    target.tvWeigh = null;
    target.llEditor = null;
    target.imageView2 = null;
    target.llExpend = null;
    target.tvTitle = null;
    target.tvText1 = null;
    target.tvText2 = null;
    target.tvText3 = null;
    target.tvText4 = null;
    target.tvText5 = null;
    target.tvText6 = null;
    target.tvText7 = null;
    target.tvText8 = null;
    target.tvText9 = null;
    target.tvTime = null;
  }
}
