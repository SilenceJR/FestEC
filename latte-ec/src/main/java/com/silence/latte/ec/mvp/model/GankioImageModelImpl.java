package com.silence.latte.ec.mvp.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.silence.latte.ec.bean.GankioImageBean;
import com.silence.latte.ec.bean.GankioRespMsg;
import com.silence.latte.ec.mvp.contract.GankioImageContract;
import com.silence.latte.net.RestCreator;

import java.util.LinkedList;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class GankioImageModelImpl implements GankioImageContract.Model {
    @Override
    public Observable<LinkedList<GankioImageBean>> getImage(int page) {
        return RestCreator.getRxRestService()
                .get("https://gank.io/api/data/福利/10/" + page, new WeakHashMap<String, Object>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<String, LinkedList<GankioImageBean>>() {
                    @Override
                    public LinkedList<GankioImageBean> apply(String s) throws Exception {
                        LinkedList<GankioImageBean> datas = new LinkedList<>();

                        final JSONArray dataArray = JSONObject.parseObject(s).getJSONArray("results");
                        final int size = dataArray.size();
                        for (int i = 0; i < size; i++) {
                            final JSONObject data = dataArray.getJSONObject(i);
                            String id = data.getString("_id");
                            String url = data.getString("url");
                            GankioImageBean bean = new GankioImageBean();
                            bean.set_id(id);
                            bean.setUrl(url);
                            datas.add(bean);
                        }

                        return datas;
                    }
                })
                ;
    }
}
