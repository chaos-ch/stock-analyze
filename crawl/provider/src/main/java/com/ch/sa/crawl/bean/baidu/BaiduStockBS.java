package com.ch.sa.crawl.bean.baidu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by he.chen on 5/9/16.
 */
public class BaiduStockBS implements Serializable{
    private String date;
    private String time;
    private BigDecimal price;
    private int volume;
    private String bsflag;//'B' for buy, 'S' for sale
    private int ccl;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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

    public String getBsflag() {
        return bsflag;
    }

    public void setBsflag(String bsflag) {
        this.bsflag = bsflag;
    }

    public int getCcl() {
        return ccl;
    }

    public void setCcl(int ccl) {
        this.ccl = ccl;
    }
}
