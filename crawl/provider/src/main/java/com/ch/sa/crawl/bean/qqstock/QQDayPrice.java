package com.ch.sa.crawl.bean.qqstock;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by he.chen on 2/26/17.
 */
public class QQDayPrice implements Serializable {
    /** 日期 */
    private String date;
    /** 开盘价 */
    private String openPrice;
    /** 收盘价 */
    private String closePrice;
    /** 当天最高价 */
    private String hightPrice;
    /** 当天最低价 */
    private String lowPrice;
    /** 成交量,单位:手 */
    private String vol;
    /** 成交额 */
    private String dealAmount;
    /** 涨跌幅 */
    private BigDecimal pricePercent;
    /** 涨跌额 */
    private BigDecimal priceRange;
    /** 昨天收盘价 */
    private String preCLosePrice;
    /** 振幅 */
    private BigDecimal amplitude;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public String getHightPrice() {
        return hightPrice;
    }

    public void setHightPrice(String hightPrice) {
        this.hightPrice = hightPrice;
    }

    public String getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }

    public String getPreCLosePrice() {
        return preCLosePrice;
    }

    public void setPreCLosePrice(String preCLosePrice) {
        this.preCLosePrice = preCLosePrice;
    }

    public BigDecimal getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(BigDecimal priceRange) {
        this.priceRange = priceRange;
    }

    public BigDecimal getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(BigDecimal amplitude) {
        this.amplitude = amplitude;
    }

    public BigDecimal getPricePercent() {
        return pricePercent;
    }

    public void setPricePercent(BigDecimal pricePercent) {
        this.pricePercent = pricePercent;
    }
}
