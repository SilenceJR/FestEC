package com.silence.festec.network;

import com.silence.latte.net.HttpMethod;
import com.silence.latte.net.rx.RxRestClient;

import java.util.Map;

import io.reactivex.Observable;

public class GankioClient extends RxRestClient {

    public GankioClient(String url, Map<String, Object> params) {
        super(url, params);
    }

}
