package com.renard.common;

import android.app.Application;
import com.renard.common.dagger.component.AppComponent;

/**
 * Created by Riven_rabbit on 2019/4/12
 *
 * @author Lemon酱
 */
public class BaseApplication extends Application {

    private static AppComponent appComponent;

    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }


    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
