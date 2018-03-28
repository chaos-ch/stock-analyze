package com.ch.sa.crawl.bean.eastmoney;

import com.ch.sa.crawl.api.bean.Stock;

import java.io.Serializable;
import java.util.List;

/**
 * 东方财富网所有股票列表
 * Created by he.chen on 11/12/16.
 */
public class EmStockSumm implements Serializable {

    private static final long serialVersionUID = -5731604551183022358L;
    private List<Stock> stockCodeList;

    public List<Stock> getStockCodeList() {
        return stockCodeList;
    }

    public void setStockCodeList(List<Stock> stockCodeList) {
        this.stockCodeList = stockCodeList;
    }
}
