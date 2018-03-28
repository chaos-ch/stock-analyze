package com.ch.sa.crawl.crawl.service;

import com.ch.sa.crawl.api.bean.StockPriceData;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by he.chen on 5/6/16.
 */
@Service
public class PriceCrawler implements Crawler<List<StockPriceData>> {

    @Resource
    private BaiduStockPriceCrawler singleCrawler;

//    @Resource
//    private StockInfoDao stockInfoDao;

    @Override
    public List<StockPriceData> fetch(String url) {
        List<String> codes = queryAllcode();
        for (String code : codes) {
            singleCrawler.fetch(this.getUrl(code));
        }
        return null;
    }

    public String url(String param) {
        return null;
    }

    public List<StockPriceData> parseResponse(String str) {
        return null;
    }

    private String getUrl(String code) {
        return null;
    }

    private List<String> queryAllcode() {
        List<String> codes = Lists.newArrayList();
//        stockInfoDao.queryAllStock();
        return codes;
    }
}
