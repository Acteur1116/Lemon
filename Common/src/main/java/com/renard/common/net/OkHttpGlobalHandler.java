package com.renard.common.net;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
public interface OkHttpGlobalHandler {
    public Response onResultResponse(String printResult, Interceptor.Chain chain, Response response);

    public Request onRequestBefore(Interceptor.Chain chain, Request request);
}
