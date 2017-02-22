package com.ch.sa.crawl.bean;

import java.io.Serializable;

/**
 * Created by he.chen on 5/6/16.
 */
public class Stock implements Serializable{
    private String code;

    /***
     * Chinese name
     */
    private String nameCn;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }
}
