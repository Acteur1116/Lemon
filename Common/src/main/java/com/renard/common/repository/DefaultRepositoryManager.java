package com.renard.common.repository;

import com.renard.common.net.download.DaoSession;
import retrofit2.Retrofit;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
public class DefaultRepositoryManager extends BaseRepositoryManager<DaoSession>{
    public DefaultRepositoryManager(Retrofit retrofit, DaoSession abstractDaoSession) {
        super(retrofit, abstractDaoSession);
    }
}
