package com.ch.sa.crawl.bean.qqstock;

import java.io.Serializable;

/**
 * tencent 自选股的信息
 * Created by he.chen on 2/26/17.
 */
public class QQStockBaseInfo implements Serializable {

    private String code;
    /**
     * 个股信息
     */
    private QQGegu gegu;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public QQGegu getGegu() {
        return gegu;
    }

    public void setGegu(QQGegu gegu) {
        this.gegu = gegu;
    }
}
