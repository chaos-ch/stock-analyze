package com.ch.sa.crawl.controller;

import com.ch.sa.crawl.bean.SearchQuery;
import com.ch.sa.crawl.bean.Stock;
import com.ch.sa.crawl.bean.baidu.BaiduPriceResponse;
import com.ch.sa.crawl.bean.baidu.BaiduStockPrice;
import com.ch.sa.crawl.bean.eastmoney.EmStockSumm;
import com.ch.sa.crawl.crawl.service.Crawler;
import com.ch.sa.crawl.price.StockBizServiceImpl;
import com.ch.sa.crawl.price.StockInfoService;
import com.ch.sa.crawl.schedule.Schedulable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by he.chen on 5/9/16.
 */
@Controller
@RequestMapping("/sa")
public class DoorController {

    private static final Logger logger = LoggerFactory.getLogger(DoorController.class);

    @Resource(name = "baiduStockPriceCrawler")
    private Crawler<BaiduPriceResponse> singleCrawler;

    @Resource(name = "stockSummaryCrawler")
    private Crawler<EmStockSumm> listCrawler;

    @Resource
    private StockInfoService stockInfoService;

    @Resource(name = "dayPriceCrawlTask")
    private Schedulable dayPriceCrawlTask;

    @Resource(name = "priceCrawlTask")
    private Schedulable priceCrawlTask;

    @Resource(name = "stockInfoTask")
    private Schedulable stockInfoTask;

    @Resource
    private StockBizServiceImpl stockBizService;

    @ResponseBody
    @RequestMapping("/singleCrawl")
    public Object singleCrawl(@RequestParam("code") String code) {

        String baiduGP = "http://gupiao.baidu.com/api/stocks/stocktimeline?from=pc&os_ver=1&cuid=xxx&vv=100&format=json&stock_code={0}&timestamp=1462611872593";
        String url = MessageFormat.format(baiduGP, code);
        BaiduPriceResponse response = singleCrawler.fetch(url);
        BaiduStockPrice price = response.getTimeLine().get(0);
//        return JsonUtil.toJsonString(response);
        return response;
    }

    @ResponseBody
    @RequestMapping("/stocklist")
    public Object listCrawl() {

//        String url = "http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?type=CT&cmd=C._A&sty=FCOIATA&sortType=C&sortRule=-1&page=1&pageSize=4000&js=var%20quote_123%3d{rank:[(x)],pages:(pc)}&token=7bc05d0d4c3c22ef9fca8c2a912d779c&jsName=quote_123&_g=0.055224825584601955";
//        BaiduPriceResponse response = singleCrawler.fetch(url);
        EmStockSumm summ = listCrawler.fetch("");
        return summ;
    }

    @ResponseBody
    @RequestMapping("refreshStocks")
    public Object saveStocks() {
        stockInfoService.saveStockAll();
        return stockInfoService.queryAll();
    }

    @ResponseBody
    @RequestMapping("pullbs")
    public Object pullBS() {
        priceCrawlTask.execute();
        return "success";
    }

    @ResponseBody
    @RequestMapping("pullDailyPrice")
    public Object pullDailyPrice() {
        dayPriceCrawlTask.execute();
        return "success";
    }

    @ResponseBody
    @RequestMapping("updateStockInfos")
    public Object updateStockInfos() {
        stockInfoTask.execute();
        return "success";
    }

    @ResponseBody
    @RequestMapping("qt")
    public Object qtStocks(@RequestParam(defaultValue = "1") int newS) {
        return stockBizService.zhangtingConcept(newS);
    }

    @ResponseBody
    @RequestMapping("search")
    public Object search(@RequestBody SearchQuery query) {
        query.setZhangfu(query.getZhangfu() != null ? query.getZhangfu() : BigDecimal.ZERO);
        Map<String, Object> map = Maps.newHashMap();
        List<Stock> stockList = Lists.newArrayList();
        stockList = stockBizService.search(query);
        map.put("stockList", stockList);
        return map;
    }
}
