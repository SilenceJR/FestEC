package com.silence.latte.net.rx;

import com.silence.latte.net.RestCreator;

import java.util.Map;

public class RxRestClientBuilder {

    private String mUrl;
    private static Map<String, Object> PARAMS = RestCreator.getParams();

    RxRestClientBuilder() {
    }

    public final RxRestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RxRestClientBuilder params(Map<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RxRestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RxRestClient build() {
        return new RxRestClient(mUrl, PARAMS);
    }

}
