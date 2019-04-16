package com.renard.common.mvp.model;

import com.renard.common.R;

/**
 * Created by Riven_rabbit on 2019/4/12
 *
 * @author Lemon酱
 */
public interface IModel<R> {
    void onDestroy();

    R getRepositoryManager();
}
