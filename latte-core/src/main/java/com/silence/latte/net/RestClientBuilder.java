package com.silence.latte.net;

import android.content.Context;

import com.silence.latte.net.callback.IError;
import com.silence.latte.net.callback.IFailure;
import com.silence.latte.net.callback.IRequest;
import com.silence.latte.net.callback.ISuccess;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author Silence
 */
public class RestClientBuilder {

    private String mUrl = null;
    private static Map<String, Object> PARAMS = RestCreator.getParams();
    private String mDownloadDir;
    private String mExtension;
    private String mName;
    private ISuccess mSuccess = null;
    private IError mError = null;
    private IFailure mFailure = null;
    private IRequest mRequest = null;
    private Context mContext = null;
    private File mFile = null;
    private RequestBody mBody = null;

    RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(Map<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder context(Context context) {
        this.mContext = context;
        return this;
    }

    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file(String path) {
        this.mFile = new File(path);
        return this;
    }

    public final RestClientBuilder downloadDir(String downloadDir) {
        this.mDownloadDir = downloadDir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder success(ISuccess success) {
        this.mSuccess = success;
        return this;
    }

    public final RestClientBuilder error(IError error) {
        this.mError = error;
        return this;
    }

    public final RestClientBuilder failure(IFailure failure) {
        this.mFailure = failure;
        return this;
    }

    public final RestClientBuilder request(IRequest request) {
        this.mRequest = request;
        return this;
    }



    public final RestClient build() {
        return new RestClient(mContext, mUrl, PARAMS, mDownloadDir, mExtension, mName, mSuccess, mError, mFailure, mRequest, mFile, mBody);
    }

}
