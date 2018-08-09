package com.silence.latte.net;

import com.silence.latte.app.ConfigType;
import com.silence.latte.app.Latte;
import com.silence.latte.net.rx.RxRestService;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Silence
 */
public class RestCreator {

    private static final class ParamsHolder{
        public static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }

    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    public static RxRestService getRxRestService() {
        return RxRestServiceHolder.RX_REST_SERVICE;
    }


    private static final class RetrofitHolder {
        private static final String BAST_URL = (String) Latte.getConfigurations().get(ConfigType.API_HOST.name());
        private static final Retrofit RETORFIT_CLOENT = new Retrofit.Builder()
                .baseUrl(BAST_URL)
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static final class OkHttpHolder{
        private static final int TIME_OUT = 60;

        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceHolder{
        private static final RestService REST_SERVICE = RetrofitHolder.RETORFIT_CLOENT.create(RestService.class);
    }

    private static final class RxRestServiceHolder{
        private static final RxRestService RX_REST_SERVICE = RetrofitHolder.RETORFIT_CLOENT.create(RxRestService.class);
    }


}
