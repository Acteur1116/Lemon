package com.renard.common.interceptor;

import com.renard.common.BaseApplication;
import com.renard.common.bean.BaseBean;
import com.renard.common.rxbus.RxBusManager;
import com.renard.common.rxbus.event.TokenEvent;
import com.renard.common.utils.Constant;
import okhttp3.*;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
public class TokenInterceptor implements Interceptor {


    @Inject
    public TokenInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = null;
        String token = null;
        String url = chain.request().url().toString();
        if (url.startsWith(Constant.BASE_URL)) {
            token = BaseApplication.getAppComponent()
                    .getSharedPreferences().getString(Constant.TOKEN, null);
            if (token != null) {
                request = chain.request().newBuilder()
                        .url(chain.request().url()).header(Constant.HEADER, token).build();
            }
        }
        Response response;
        if (request != null) {
            response = chain.proceed(request);
        } else {
            response = chain.proceed(chain.request());
        }
        if (token != null && url.startsWith(Constant.BASE_URL) && response.body() != null && isPlaintext(response.body().contentType())) {
            return bodyToString(response);
        }
        return response;
    }


    private static boolean isPlaintext(MediaType mediaType) {
        if (mediaType == null)
            return false;
        if (mediaType.type() != null && mediaType.type().equals("text")) {
            return true;
        }
        String subtype = mediaType.subtype();
        if (subtype != null) {
            subtype = subtype.toLowerCase();
            return subtype.contains("x-www-form-urlencoded") || subtype.contains("json") || subtype.contains("xml") || subtype.contains("html");
        }
        return false;
    }


    private Response bodyToString(Response response) {
        Response.Builder builder = response.newBuilder();
        Response clone = builder.build();
        ResponseBody responseBody = clone.body();
        byte[] bytes = null;
        try {
            bytes = toByteArray(responseBody.byteStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        MediaType contentType = responseBody.contentType();
        String body = new String(bytes, getCharset(contentType));
        BaseBean baseBean = BaseApplication.getAppComponent().getGson()
                .fromJson(body, BaseBean.class);
        if (Constant.tokenCodeList.contains(baseBean.getCode())) {
            RxBusManager.getInstance().post(new TokenEvent());
        }
        responseBody = ResponseBody.create(responseBody.contentType(), bytes);
        return response.newBuilder().body(responseBody).build();
    }


    private static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int len;
        byte[] buffer = new byte[4096];
        while ((len = inputStream.read(buffer)) != -1)
            output.write(buffer, 0, len);
        output.close();
        return output.toByteArray();
    }

    private static final Charset UTF8 = Charset.forName("UTF-8");

    private static Charset getCharset(MediaType contentType) {
        Charset charset = contentType != null ? contentType.charset() : UTF8;
        if (charset == null)
            charset = UTF8;
        return charset;
    }
}
