package com.renard.common.net.download.upload;

import com.renard.common.net.download.FileInfo;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
public interface UpLoadListener  {
    /**
     * 开始上传
     * @param fileInfo
     */
    void onStart(FileInfo fileInfo);
    /**
     * 更新上传进度
     * @param fileInfo
     */
    void onUpdate(FileInfo fileInfo);
    /**
     * 停止上传
     * @param fileInfo
     */
    void onStop(FileInfo fileInfo);
    /**
     * 上传成功
     * @param fileInfo
     */
    void onComplete(FileInfo fileInfo);
    /**
     * 取消上传
     * @param fileInfo
     */
    void onCancel(FileInfo fileInfo);
    /**
     * 上传失败
     * @param fileInfo
     */
    void onError(FileInfo fileInfo, String errorMsg);

}
