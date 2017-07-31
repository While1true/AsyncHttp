package com.example.asynchttplib;

import android.text.TextUtils;

import com.loopj.android.http.BaseJsonHttpResponseHandler;

/**
 * 描述：嵌入Gson解析
 */
public abstract class GsonHttpResponseHandler<T> extends BaseJsonHttpResponseHandler<T> {

    private Class<T> clazz;

    public GsonHttpResponseHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    protected T parseResponse(String rawJsonData, boolean isFailure) {
        if (!isFailure && !TextUtils.isEmpty(rawJsonData)) {
            return GSONUtils.parseJson(clazz, rawJsonData);
        }
        return null;
    }

}
