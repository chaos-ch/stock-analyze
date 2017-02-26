package com.ch.sa.crawl.bean.qqstock;

import java.io.Serializable;

/**
 * 分红
 * Created by he.chen on 2/26/17.
 */
public class QQStockFenhong implements Serializable {
    /**
     * 年度
     */
    private String nd;
    private String sg;
    private String zz;
    /**
     * 分红:每10股派息数
     */
    private String fh;
    /**
     * 股权登记日
     */
    private String djr;
    /**
     * 除权日
     */
    private String cqr;

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getSg() {
        return sg;
    }

    public void setSg(String sg) {
        this.sg = sg;
    }

    public String getZz() {
        return zz;
    }

    public void setZz(String zz) {
        this.zz = zz;
    }

    public String getFh() {
        return fh;
    }

    public void setFh(String fh) {
        this.fh = fh;
    }

    public String getDjr() {
        return djr;
    }

    public void setDjr(String djr) {
        this.djr = djr;
    }

    public String getCqr() {
        return cqr;
    }

    public void setCqr(String cqr) {
        this.cqr = cqr;
    }
}
