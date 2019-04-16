package com.renard.common.mvp.model;

import com.renard.common.repository.DefaultRepositoryManager;

import javax.inject.Inject;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
public class DefaultModel extends BaseModel<DefaultRepositoryManager>{
    @Inject
    public DefaultModel(DefaultRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
