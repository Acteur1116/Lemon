package com.renard.common.mvp.view;

import com.renard.common.baseadapter.empty.EmptyLayout;
import com.trello.rxlifecycle3.LifecycleTransformer;

/**
 * Created by Riven_rabbit on 2019/4/16
 *
 * @author Lemon酱
 */
public interface IView<T> {

    /**
     * 显示加载
     */
    void showLoading(String loadMessage);

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 显示信息
     */
    void showError(String message, EmptyLayout.OnRetryListener listener);


    /**
     * 展示空布局
     */
    void showEmptyView();

    /**
     * 更新数据
     * @param t
     */
    void updateData(T t);


    <Y> LifecycleTransformer<Y> bindLife();

}