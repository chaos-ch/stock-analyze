package com.ch.sa.crawl.store.bean;

import java.io.Serializable;

/**
 * Created by he.chen on 4/4/17.
 */
public class BaseInfo implements Serializable {

    private String code;
    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
