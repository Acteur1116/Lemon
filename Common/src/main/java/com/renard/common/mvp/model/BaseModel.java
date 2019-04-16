package com.renard.common.mvp.model;

import com.renard.common.repository.BaseRepositoryManager;

/**
 * Created by Riven_rabbit on 2019/4/16
 *
 * @author Lemon酱
 */
public class BaseModel<R extends BaseRepositoryManager> implements IModel<R> {


    protected R baseRepositoryManager;


    public BaseModel(R repositoryManager) {
        this.baseRepositoryManager = repositoryManager;
    }

    @Override
    public void onDestroy() {
        baseRepositoryManager.clearAllCache();
    }

    @Override
    public R getRepositoryManager() {
        return baseRepositoryManager;
    }
}
