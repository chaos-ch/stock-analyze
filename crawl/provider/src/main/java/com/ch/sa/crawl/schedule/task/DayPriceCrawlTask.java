package com.ch.sa.crawl.schedule.task;

import com.ch.base.lang.time.DateHelper;
import com.ch.sa.crawl.bean.Stock;
import com.ch.sa.crawl.bean.baidu.BaiduPriceResponse;
import com.ch.sa.crawl.bean.qqstock.QQDailyPriceResponse;
import com.ch.sa.crawl.bean.qqstock.QQResponse;
import com.ch.sa.crawl.crawl.adaptor.BaiduPriceAdaptor;
import com.ch.sa.crawl.crawl.service.Crawler;
import com.ch.sa.crawl.price.StockInfoService;
import com.ch.sa.crawl.price.StockPriceService;
import com.ch.sa.crawl.schedule.Schedulable;
import com.ch.sa.crawl.store.bean.PriceData;
import com.ch.sa.crawl.util.JsonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日线价格抓取任务
 * Created by he.chen on 5/4/16.
 */
@Service
public class DayPriceCrawlTask implements Schedulable {

    private static final Logger logger = LoggerFactory.getLogger(DayPriceCrawlTask.class);
    @Resource(name = "qQDayPriceCrawler")
    private Crawler<QQDailyPriceResponse> sinpleCrawler;
    @Resource
    private StockInfoService stockInfoService;
    @Resource
    private StockPriceService priceService;

//    @Scheduled()
    public void execute() {
        List<Stock> stockList = stockInfoService.queryAll();
        if (CollectionUtils.isEmpty(stockList)) {
            return;
        }
        Date now = new Date();

        for (Stock stock : stockList) {
            try {


                String code = stock.getCode();
                if (code.startsWith("6")) {
                    code = "sh" + code;
                } else {
                    code = "sz" + code;
                }
                QQDailyPriceResponse response = sinpleCrawler.fetch(code);
//            PriceData priceData = priceAdaptor.adapt(response);
//            priceData.setCode(code);
//            priceData.setCreateDate(new Date());
                PriceData priceData = new PriceData();
                priceData.setCode(code.substring(2));
                priceData.setCreateDate(new Date());
                Date priceDate = DateHelper.parseyyyyMMddHHmmss(response.getData().getDate());
                priceData.setData(JsonUtil.toJsonString(response.getData()));
                priceData.setDate(priceDate);
                priceService.saveDayPrice(priceData);
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
    public String cron() {
        return null;
    }
}
