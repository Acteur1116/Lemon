package com.renard.common.imageloader;

import android.content.Context;
import com.renard.common.imageloader.base.BaseImageLoaderConfig;
import com.renard.common.imageloader.base.BaseImageLoaderStrategy;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Riven_rabbit on 2019/4/12
 *
 * @author Lemon酱
 */
@Singleton
public class ImageLoader {

    private BaseImageLoaderStrategy baseImageLoaderStrategy;

    @Inject
    public ImageLoader(BaseImageLoaderStrategy baseImageLoaderStrategy) {
        this.baseImageLoaderStrategy = baseImageLoaderStrategy;
    }

    public void setBaseImageLoaderStrategy(BaseImageLoaderStrategy baseImageLoaderStrategy) {
        this.baseImageLoaderStrategy = baseImageLoaderStrategy;
    }

    public <T extends BaseImageLoaderConfig> void loadImage(Context context, T config) {
        baseImageLoaderStrategy.loadImage(context, config);
    }


}
