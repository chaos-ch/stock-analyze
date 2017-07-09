package com.ch.sa.crawl.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by he.chen on 5/6/16.
 */
public class Stock implements Serializable{
    private String code;

    /***
     * Chinese name
     */
    private String nameCn;

    private BigDecimal zhangfu;

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

    public BigDecimal getZhangfu() {
        return zhangfu;
    }

    public void setZhangfu(BigDecimal zhangfu) {
        this.zhangfu = zhangfu;
    }
}
