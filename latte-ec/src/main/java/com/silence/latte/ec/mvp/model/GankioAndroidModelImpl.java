package com.silence.latte.ec.mvp.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.silence.latte.ec.bean.GankioAndroidBean;
import com.silence.latte.ec.bean.GankioImageBean;
import com.silence.latte.ec.mvp.contract.GankioAndroidContract;
import com.silence.latte.net.RestCreator;

import java.util.LinkedList;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class GankioAndroidModelImpl implements GankioAndroidContract.Model {
    @Override
    public Observable<LinkedList<GankioAndroidBean>> getData(int page) {
        return RestCreator.getRxRestService()
                .get("https://gank.io/api/data/Android/10/" + page, new WeakHashMap<String, Object>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<String, LinkedList<GankioAndroidBean>>() {
                    @Override
                    public LinkedList<GankioAndroidBean> apply(String s) throws Exception {
                        LinkedList<GankioAndroidBean> datas = new LinkedList<>();

                        final JSONArray dataArray = JSONObject.parseObject(s).getJSONArray("results");
                        final int size = dataArray.size();
                        for (int i = 0; i < size; i++) {
                            final JSONObject data = dataArray.getJSONObject(i);
                            String id = data.getString("_id");
                            String url = data.getString("url");
                            String desc = data.getString("desc");
                            JSONArray images = data.getJSONArray("images");
                            LinkedList<String> image = new LinkedList<>();
                            if (null != images) {
                                final int imageSize = images.size();
                                for (int j = 0; j < imageSize; j++) {
                                    String o = (String) images.get(j);
                                    image.add(o);
                                }
                            }

                            GankioAndroidBean bean = new GankioAndroidBean();
                            bean.set_id(id);
                            bean.setUrl(url);
                            bean.setDesc(desc);
                            bean.setImages(image);
                            datas.add(bean);
                        }

                        return datas;
                    }
                })
                ;
    }
}
