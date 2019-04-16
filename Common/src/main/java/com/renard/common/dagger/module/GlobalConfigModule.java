package com.renard.common.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.renard.common.imageloader.base.BaseImageLoaderStrategy;
import com.renard.common.imageloader.glide.GlideImageLoaderStrategy;
import com.renard.common.interceptor.LogInterceptor;
import com.renard.common.interceptor.TokenInterceptor;
import com.renard.common.manager.ActivityManager;
import com.renard.common.mvp.model.DefaultModel;
import com.renard.common.net.OkHttpGlobalHandler;
import com.renard.common.net.TrustAllCerts;
import com.renard.common.net.download.DaoMaster;
import com.renard.common.net.download.DaoSession;
import com.renard.common.repository.DefaultRepositoryManager;
import com.renard.common.utils.Constant;
import com.renard.common.utils.FileUtil;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.greenrobot.greendao.database.Database;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Riven_rabbit on 2019/4/13
 *
 * @author Lemon酱
 */
@Module
public class GlobalConfigModule {

    private Application application;


    public GlobalConfigModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public DaoSession provideDaoSession() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(application, "common_db", null);
        Database database = devOpenHelper.getWritableDb();
        DaoMaster master = new DaoMaster(database);
        return master.newSession();
    }

    @Provides
    public DefaultRepositoryManager provideRepositoryManager(Retrofit retrofit, DaoSession daoSession) {
        return new DefaultRepositoryManager(retrofit, daoSession);
    }

    @Provides
    public DefaultModel provideDefaultModel(DefaultRepositoryManager defaultRepositoryManager) {
        return new DefaultModel(defaultRepositoryManager);
    }


    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder okHttpBuilder) {
        return okHttpBuilder.build();
    }


    @Singleton
    @Provides
    public Interceptor provideLogInterceptor(OkHttpGlobalHandler okHttpGlobalHandler) {
        return new LogInterceptor(okHttpGlobalHandler, LogInterceptor.Level.BODY);
    }


    @Singleton
    @Provides
    public OkHttpGlobalHandler provideGlobalNetHandler() {
        return new OkHttpGlobalHandler() {
            @Override
            public Response onResultResponse(String printResult, Interceptor.Chain chain, Response response) {
                return null;
            }

            @Override
            public Request onRequestBefore(Interceptor.Chain chain, Request request) {
                return request;
            }
        };
    }


    @Singleton
    @Provides
    public OkHttpClient.Builder provideOkHttpBuilder(@Nullable final OkHttpGlobalHandler handler, @Nullable Interceptor logInterceptor
            , TokenInterceptor tokenInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS);
        //        自定义签名证书
        //                builder.sslSocketFactory(SSLConfig.getSSLSocketFactory(BaseApplication.getInstance()), (X509TrustManager) Objects.requireNonNull(SSLConfig.getTrustManager(BaseApplication.getInstance())));
        builder.sslSocketFactory(TrustAllCerts.createSSLSocketFactory());
        builder.hostnameVerifier(new TrustAllCerts.TrustAllHostnameVerifier());
        if (tokenInterceptor != null) {
            builder.addNetworkInterceptor(tokenInterceptor);
        }
        if (logInterceptor != null) {
            builder.addNetworkInterceptor(logInterceptor);
        }
        if (handler != null) {
            builder.addInterceptor(chain -> chain.proceed(handler.onRequestBefore(chain, chain.request())));
        }
        return builder;
    }


    @Singleton
    @Provides
    public BaseImageLoaderStrategy provideImageLoader() {
        return new GlideImageLoaderStrategy();
    }

    @Provides
    @Singleton
    public ActivityManager provideActivityManager() {
        ActivityManager activityManager = new ActivityManager(application);
        application.registerActivityLifecycleCallbacks(activityManager);
        return activityManager;
    }


    @Provides
    @Singleton
    public Retrofit provideRetrofit(Retrofit.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofitBuilder(OkHttpClient okHttpClient, @Nullable Gson gson) {
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder.baseUrl(Constant.BASE_URL).client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));
    }


    @Singleton
    @Provides
    public Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls().enableComplexMapKeySerialization();
        return gsonBuilder.create();
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences() {
        return application.getSharedPreferences("common", Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    public File provideCacheFile() {
        return FileUtil.getDefaultCacheFile(application);
    }


}
