package com.ch.sa.crawl.crawl.service;

import com.ch.base.lang.serial.JsonUtil;
import com.ch.sa.crawl.bean.baidu.BaiduPriceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * crawler for price data
 * Created by he.chen on 5/5/16.
 */
@Service
public class BaiduStockPriceCrawler extends AbstractCrawler<BaiduPriceResponse> {

    private static final Logger logger = LoggerFactory.getLogger(BaiduStockPriceCrawler.class);

    private static final String BAIDU_URL = "http://gupiao.baidu.com/api/stocks/stocktimeline?from=pc&os_ver=1&cuid=xxx&vv=100&format=json&stock_code={0}&timestamp={1}";


    public String url(String code) {

        return MessageFormat.format(BAIDU_URL, code, System.currentTimeMillis());
    }

    public BaiduPriceResponse parseResponse(String str) {
        try {
            return JsonUtil.parseJson(str, BaiduPriceResponse.class);
        } catch (IOException e) {
            logger.error("baidu stock parse json ");
        }
        return null;
    }




}
