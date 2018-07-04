package com.silence.latte.net.download;

import com.silence.latte.net.RestCreator;
import com.silence.latte.net.callback.IError;
import com.silence.latte.net.callback.IFailure;
import com.silence.latte.net.callback.IRequest;
import com.silence.latte.net.callback.ISuccess;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownloadHandler {

    private final String URL;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final IRequest REQUEST;

    public DownloadHandler(String url, String downloadDir, String extension,
                           String name, ISuccess success, IError error, IFailure failure, IRequest request) {
        this.URL = url;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.REQUEST = request;
    }

    public final void handleDownload() {
        if (null != REQUEST) {
            REQUEST.onRequestStart();
        }

        RestCreator.getRestService().download(URL, PARAMS)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
    }

}
