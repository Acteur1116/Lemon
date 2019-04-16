package com.renard.common.net.download.upload;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
public interface UpLoadProgressListener {
    void onUpdate(long hasUpLoadSize, long totalUpLoadSize);
}
