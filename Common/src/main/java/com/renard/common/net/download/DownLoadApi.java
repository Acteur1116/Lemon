package com.renard.common.net.download;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
public interface DownLoadApi {
    @Streaming
    @GET
    public Observable<ResponseBody> downLoad(@Header("RANGE") String start, @Url String url);
}
