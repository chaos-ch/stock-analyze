package com.ch.sa.crawl.bean.baidu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** bd st price
 * Created by he.chen on 5/9/16.
 */
public class BaiduStockPrice implements Serializable{
    private String  date;
    private String time;
    private BigDecimal price;
    private int volume;
    private BigDecimal avgPrice;
    private int ccl;
    private int netChangeRatio;
    private BigDecimal preClose;
    private int amount;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
