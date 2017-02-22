package com.ch.sa.crawl.store.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by he.chen on 5/11/16.
 */
public class PriceDataDetail {
    private Date time;
    private BigDecimal price;
    private int volume;
    private BigDecimal avgPrice;
    private int ccl;
    private int netChangeRatio;
    private BigDecimal preClose;
    private int amount;



    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }

    public int getCcl() {
        return ccl;
    }

    public void setCcl(int ccl) {
        this.ccl = ccl;
    }

    public int getNetChangeRatio() {
        return netChangeRatio;
    }

    public void setNetChangeRatio(int netChangeRatio) {
        this.netChangeRatio = netChangeRatio;
    }

    public BigDecimal getPreClose() {
        return preClose;
    }

    public void setPreClose(BigDecimal preClose) {
        this.preClose = preClose;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
