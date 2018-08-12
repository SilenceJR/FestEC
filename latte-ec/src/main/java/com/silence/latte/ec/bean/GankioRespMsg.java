package com.silence.latte.ec.bean;

import java.util.LinkedList;

public class GankioRespMsg<T> {
    private boolean error;
    private LinkedList<T> results;

    public GankioRespMsg() {
    }

    public GankioRespMsg(boolean error, LinkedList<T> results) {
        this.error = error;
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public LinkedList<T> getResults() {
        return results;
    }

    public void setResults(LinkedList<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GankioRespMsg{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
