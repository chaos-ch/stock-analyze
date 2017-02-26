package com.ch.sa.crawl.bean.qqstock;

import java.io.Serializable;

/**
 * Created by he.chen on 2/26/17.
 */
public class QQResponse implements Serializable {
    private int code;
    private String msg;
    private QQStockBaseInfo data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public QQStockBaseInfo getData() {
        return data;
    }

    public void setData(QQStockBaseInfo data) {
        this.data = data;
    }
}
