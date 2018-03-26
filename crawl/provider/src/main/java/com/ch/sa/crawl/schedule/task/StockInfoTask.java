package com.ch.sa.crawl.schedule.task;

import com.ch.sa.crawl.bean.Stock;
import com.ch.sa.crawl.bean.qqstock.QQStockBaseInfo;
import com.ch.sa.crawl.bean.qqstock.QQStockBaseInfoResponse;
import com.ch.sa.crawl.crawl.adaptor.BaiduPriceAdaptor;
import com.ch.sa.crawl.crawl.service.Crawler;
import com.ch.sa.crawl.price.StockInfoService;
import com.ch.sa.crawl.price.StockPriceService;
import com.ch.sa.crawl.schedule.Schedulable;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 抓取任务
 * Created by he.chen on 5/4/16.
 */
@Service
public class StockInfoTask implements Schedulable {

    private static final Logger logger = LoggerFactory.getLogger(StockInfoTask.class);

    @Resource(name = "qQStockInfoCrawler")
    private Crawler<QQStockBaseInfoResponse> sinpleCrawler;
    @Resource
    private StockInfoService stockInfoService;
    @Resource
    private StockPriceService priceService;
    @Resource
    private BaiduPriceAdaptor priceAdaptor;

    @Override
    @Scheduled(fixedRateString ="1000 * 60 * 60 * 5")
    public void execute() {
        logger.info("save stock info task start...");
        stockInfoService.saveStockAll();
        List<Stock> stockList = stockInfoService.queryAll();
        if (CollectionUtils.isEmpty(stockList)) {
            return;
        }
        Date now = new Date();

        for (Stock stock : stockList) {
            try {


                String code = stock.getCode();
                String stockCode = new String(code);
                if (code.startsWith("6")) {
                    stockCode = "sh" + code;
                } else {
                    stockCode = "sz" + code;
                }
                QQStockBaseInfoResponse response = sinpleCrawler.fetch(stockCode);
                QQStockBaseInfo baseInfo = response.getData();
                baseInfo.setCode(code);
                stockInfoService.updateBaseInfo(baseInfo);
            } catch (Exception e) {
                logger.error("update stock list failed", e);
            }
        }
    }



    public static void main(String[] args) {
        Date now = new Date();
        Date truncate = DateUtils.truncate(now, Calendar.DATE);
        System.out.println(truncate);
    }
    @Override
    public String cron() {
        return null;
    }
}
