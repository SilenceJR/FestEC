package com.silence.latte.net.rx;

import com.silence.latte.net.HttpMethod;
import com.silence.latte.net.RestClientBuilder;
import com.silence.latte.net.RestCreator;
import com.silence.latte.net.callback.IRequest;

import java.util.Map;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Call;

public class RxRestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();

    public RxRestClient(String url,
                        Map<String, Object> params) {
        this.URL = url;
        PARAMS.putAll(params);
    }

    public static RxRestClientBuilder builder() {
        return new RxRestClientBuilder();
    }

    private Observable<String> request(HttpMethod method) {
        final RxRestService service = RestCreator.getRxRestService();

        Observable<String> observable = null;


        switch (method) {
            case GET:
                observable = service.get(URL, PARAMS);
                break;
            case POST:
                observable = service.post(URL, PARAMS);
                break;
            case PUT:
                observable = service.put(URL, PARAMS);
                break;
            case POST_RAW:
//                observer = service.(URL, PARAMS);
                break;
            case UPLOAD:
                break;
            default:
                break;
        }

        return observable;

    }

    public final Observable get() {
        return request(HttpMethod.GET);
    }

    public final Observable<String> post() {
        return request(HttpMethod.POST);
    }

    public final Observable<String> put() {
        return request(HttpMethod.PUT);
    }
}
