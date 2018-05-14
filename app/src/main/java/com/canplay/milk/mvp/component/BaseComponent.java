package com.canplay.milk.mvp.component;


import com.canplay.milk.base.AppComponent;
import com.canplay.milk.fragment.DataFragment;
import com.canplay.milk.mvp.ActivityScope;
import com.canplay.milk.mvp.activity.account.ForgetPswActivity;
import com.canplay.milk.mvp.activity.account.LoginActivity;
import com.canplay.milk.mvp.activity.account.RegisteredActivity;
import com.canplay.milk.mvp.activity.account.RegisteredSecondActivity;

import dagger.Component;

/**
 * Created by leo on 2016/9/27.
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface BaseComponent{

    void inject(LoginActivity binderActivity);
    void inject(ForgetPswActivity binderActivity);
    void inject(RegisteredSecondActivity binderActivity);
    void inject(RegisteredActivity binderActivity);
    void inject(DataFragment binderActivity);


}
