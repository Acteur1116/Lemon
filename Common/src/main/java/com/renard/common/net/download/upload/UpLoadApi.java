package com.renard.common.net.download.upload;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

import java.util.Map;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
public interface UpLoadApi {
    @POST
    public Observable<Response> upLoad(@Url String url, @PartMap Map<String, RequestBody> requestBodyMap);

    @POST
    public Observable<Response> upLoad(@Url String url, @Part MultipartBody.Part part);
}
