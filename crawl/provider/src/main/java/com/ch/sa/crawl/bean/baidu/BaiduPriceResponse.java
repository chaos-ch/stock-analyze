package com.ch.sa.crawl.bean.baidu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * price response
 * Created by he.chen on 5/9/16.
 */
public class BaiduPriceResponse implements Serializable {
    private int errorNo;
    private String errorMsg;
    private List<BaiduStockPrice> timeLine;
    private Date latestTimelineStamp;
    private BigDecimal preClose;
    private List<BaiduStockBS> tick;

    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<BaiduStockPrice> getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(List<BaiduStockPrice> timeLine) {
        this.timeLine = timeLine;
    }

    public Date getLatestTimelineStamp() {
        return latestTimelineStamp;
    }

    public void setLatestTimelineStamp(Date latestTimelineStamp) {
        this.latestTimelineStamp = latestTimelineStamp;
    }

    public BigDecimal getPreClose() {
        return preClose;
    }

    public void setPreClose(BigDecimal preClose) {
        this.preClose = preClose;
    }

    public List<BaiduStockBS> getTick() {
        return tick;
    }

    public void setTick(List<BaiduStockBS> tick) {
        this.tick = tick;
    }
}
