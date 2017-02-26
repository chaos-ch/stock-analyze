package com.ch.sa.crawl.bean.qqstock;

import java.io.Serializable;

/**
 * 营业收入
 * Created by he.chen on 2/26/17.
 */
public class QQYysr implements Serializable {
    /**
     * 收入类型
     */
    private String sector;
    /**
     * 收入金额
     */
    private String income;
    /**
     * 单元
     */
    private String unit;

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
