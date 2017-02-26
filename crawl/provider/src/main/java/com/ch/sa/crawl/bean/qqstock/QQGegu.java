package com.ch.sa.crawl.bean.qqstock;

import java.io.Serializable;
import java.util.List;

/**
 * gegu 信息
 * Created by he.chen on 2/26/17.
 */
public class QQGegu implements Serializable {

    /**
     * 股票代码
     */
    private String code;
    /**
     * 公司名字
     */
    private String gsmz;
    /**
     * 日期
     */
    private String riqi;
    /**
     * 发行价格
     */
    private String jg;
    /**
     * 发行数量
     */
    private String fxs;
    /**
     * 主营业务
     */
    private String yw;
    /**
     * 所属地区
     */
    private String dy;
    /**
     * 行业
     */
    private String hy;
//    private String holder;
    /**
     * 行业
     */
    private List<QQCategory> plate;
    /**
     * 所属概念
     */
    private List<QQCategory> concept;
    /**
     * 营业收入
     */
    private List<QQYysr> yysr;
    /**
     * 没年度分红
     */
    private List<QQStockFenhong> fenhong;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGsmz() {
        return gsmz;
    }

    public void setGsmz(String gsmz) {
        this.gsmz = gsmz;
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getFxs() {
        return fxs;
    }

    public void setFxs(String fxs) {
        this.fxs = fxs;
    }

    public String getYw() {
        return yw;
    }

    public void setYw(String yw) {
        this.yw = yw;
    }

    public String getDy() {
        return dy;
    }

    public void setDy(String dy) {
        this.dy = dy;
    }

    public String getHy() {
        return hy;
    }

    public void setHy(String hy) {
        this.hy = hy;
    }

//    public String getHolder() {
//        return holder;
//    }
//
//    public void setHolder(String holder) {
//        this.holder = holder;
//    }

    public List<QQCategory> getPlate() {
        return plate;
    }

    public void setPlate(List<QQCategory> plate) {
        this.plate = plate;
    }

    public List<QQCategory> getConcept() {
        return concept;
    }

    public void setConcept(List<QQCategory> concept) {
        this.concept = concept;
    }

    public List<QQYysr> getYysr() {
        return yysr;
    }

    public void setYysr(List<QQYysr> yysr) {
        this.yysr = yysr;
    }

    public List<QQStockFenhong> getFenhong() {
        return fenhong;
    }

    public void setFenhong(List<QQStockFenhong> fenhong) {
        this.fenhong = fenhong;
    }
}
