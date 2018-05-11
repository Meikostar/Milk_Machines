package com.canplay.milk.mvp.component;


import com.canplay.milk.base.AppComponent;
import com.canplay.milk.mvp.ActivityScope;
import com.canplay.milk.mvp.activity.account.LoginActivity;
import dagger.Component;

/**
 * Created by leo on 2016/9/27.
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface BaseComponent{

    void inject(LoginActivity binderActivity);


}
