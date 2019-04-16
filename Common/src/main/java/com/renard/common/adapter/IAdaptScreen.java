package com.renard.common.adapter;

/**
 * Created by Riven_rabbit on 2019/4/16
 *
 * @author Lemon酱
 */
public interface IAdaptScreen {
    boolean isBaseOnWidth();
    int getScreenSize();
    boolean cancelAdapt();
    boolean needResetAdapt();
}
