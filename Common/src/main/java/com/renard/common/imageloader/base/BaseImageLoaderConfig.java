package com.renard.common.imageloader.base;

import android.view.View;

/**
 * Created by Riven_rabbit on 2019/4/12
 *
 * @author Lemon酱
 */
public class BaseImageLoaderConfig {
    private View view;
    private String url;
    private int errorResId;
    private int placeHolderResId;

    private int width;
    private int height;

    public int getHeight() {
        return height;
    }


    public int getWidth() {
        return width;
    }


    public void setHeight(int height) {
        this.height = height;
    }


    public void setWidth(int width) {
        this.width = width;
    }

    public View getView() {
        return view;
    }

    public void setView(View imageView) {
        this.view = imageView;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getErrorResId() {
        return errorResId;
    }

    public void setErrorResId(int errorResId) {
        this.errorResId = errorResId;
    }

    public int getPlaceHolderResId() {
        return placeHolderResId;
    }

    public void setPlaceHolderResId(int placeHolderResId) {
        this.placeHolderResId = placeHolderResId;
    }
}
