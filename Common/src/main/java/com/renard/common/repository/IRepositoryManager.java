package com.renard.common.repository;

import com.renard.common.net.download.DaoSession;
import org.greenrobot.greendao.AbstractDaoSession;

/**
 * Created by Riven_rabbit on 2019/4/16
 *
 * @author Lemon酱
 */
public interface IRepositoryManager <D extends AbstractDaoSession> {
    <T> T getApi(Class<T> retrofitClass);


    <T> void clearApi(Class<T> retrofitClass);



    D getDaoSession();




    void clearAllCache();


//    DaoSession getDaoSession();

}
