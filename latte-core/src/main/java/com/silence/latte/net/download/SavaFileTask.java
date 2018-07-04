package com.silence.latte.net.download;

import android.os.AsyncTask;

import com.silence.latte.net.callback.IError;
import com.silence.latte.net.callback.IFailure;
import com.silence.latte.net.callback.IRequest;
import com.silence.latte.net.callback.ISuccess;

import java.io.File;
import java.io.InputStream;
import java.util.Observable;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class SavaFileTask extends AsyncTask<Object, Void, File> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;


    public SavaFileTask(IRequest REQUEST, ISuccess SUCCESS, IError ERROR, IFailure FAILURE) {
        this.REQUEST = REQUEST;
        this.SUCCESS = SUCCESS;
        this.ERROR = ERROR;
        this.FAILURE = FAILURE;
    }

    @Override
    protected File doInBackground(Object... objects) {
        String downloadDir = (String) objects[0];
        String extension = (String) objects[1];
        final ResponseBody body = (ResponseBody) objects[2];
        final String name = (String) objects[3];
        final InputStream is = body.byteStream();
        if (null == downloadDir || "".equals(downloadDir)) {
            downloadDir = "down_loads";
        }
        if (null == extension || "".equals(extension)) {
            downloadDir = "";
        }
        if (null == name) {
            return null;
        }


        return null;
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (null != SUCCESS) {
            SUCCESS.onSuccess(file.getAbsolutePath());
        }
        if (null != REQUEST) {
            REQUEST.onRequestEnd();
        }
    }
}
