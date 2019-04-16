package com.renard.common.dagger.component;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.renard.common.dagger.module.GlobalConfigModule;
import com.renard.common.imageloader.ImageLoader;
import com.renard.common.manager.ActivityManager;
import com.renard.common.net.download.DaoSession;
import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import javax.inject.Singleton;
import java.io.File;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
@Singleton
@Component(modules = GlobalConfigModule.class)
public interface AppComponent {
    public ImageLoader getImageLoader();

    public Gson getGson();

    public File getCacheFile();

    public OkHttpClient getOkHttpClient();

    public ActivityManager getActivityManager();

    public DaoSession getDaoSession();

    public OkHttpClient.Builder getOkHttpClientBuilder();

    public Retrofit getRetrofit();

    public SharedPreferences getSharedPreferences();

    public Retrofit.Builder getRetrofitBuilder();
}
