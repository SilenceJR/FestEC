package com.silence.festec.network;

import com.silence.festec.moder.GankioModer;
import com.silence.latte.net.rx.RxRestService;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GanioRestService extends RxRestService {

    @GET("http://gank.io/api/xiandu/data/id/appinn/count/10/page/1")
    Observable<GankioModer> ganio();


}
