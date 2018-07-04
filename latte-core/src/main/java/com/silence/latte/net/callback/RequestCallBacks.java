package com.silence.latte.net.callback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestCallBacks implements Callback<String>{

    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final IRequest REQUEST;

    public RequestCallBacks( IRequest request, ISuccess success, IError error, IFailure failure) {
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.REQUEST = request;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (null != SUCCESS) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (null != ERROR) {
                ERROR.onError(response.code(), response.message());
            }
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (null != FAILURE) {
            FAILURE.onFailure();
        }

        if (null != REQUEST) {
            REQUEST.onRequestEnd();
        }
    }
}
