package com.renard.common.imageloader.base;

import android.content.Context;

/**
 * Created by Riven_rabbit on 2019/4/16
 *
 * @author Lemon酱
 */
public interface BaseImageLoaderStrategy<T extends BaseImageLoaderConfig> {
    void loadImage(Context context, T config);
}
