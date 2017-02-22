package com.ch.sa.crawl.crawl.service;

import com.ch.base.lang.net.HttpUtil;
import com.ch.base.lang.serial.JsonUtil;
import com.ch.sa.crawl.bean.baidu.BaiduPriceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * crawler for price data
 * Created by he.chen on 5/5/16.
 */
@Service
public class SingleStockDataCrawler implements Crawler<BaiduPriceResponse> {
    private static final Logger logger = LoggerFactory.getLogger(SingleStockDataCrawler.class);
    @Override
    public BaiduPriceResponse fetch(String url) {
        try {
            String content = HttpUtil.getContent(url, 3);
            return JsonUtil.parseJson(content, BaiduPriceResponse.class);
        } catch (Exception e) {
            logger.error("http get content error", e);
        }
        return null;
    }

    public String url(String param) {
        return null;
    }

    public BaiduPriceResponse parseResponse(String str) {
        return null;
    }

    public static void main(String[] args) {
        try {
            String content = HttpUtil.getContent("http://gupiao.baidu.com/api/stocks/stocktimeline?from=pc&os_ver=1&cuid=xxx&vv=100&format=json&stock_code=sz000541&timestamp=1462611872593");
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
