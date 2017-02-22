package com.ch.sa.crawl.store.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by he.chen on 5/11/16.
 */
public class PriceData implements Serializable{
    private String code;
    private Date date;
    private String Data;
    private Date createDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
