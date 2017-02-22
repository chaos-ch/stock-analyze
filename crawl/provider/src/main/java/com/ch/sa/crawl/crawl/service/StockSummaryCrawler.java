package com.ch.sa.crawl.crawl.service;

import com.ch.sa.crawl.bean.Stock;
import com.ch.sa.crawl.bean.eastmoney.EmStockSumm;
import com.ch.sa.crawl.util.JsonUtil;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by he.chen on 11/12/16.
 */
@Service
public class StockSummaryCrawler extends AbstractCrawler<EmStockSumm> {


    private static final Splitter splitter = Splitter.on(",");
    private static final String URL = "http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?type=CT&cmd=C._A&sty=FCOIATA&sortType=C&sortRule=-1&page=1&pageSize=4000&token=7bc05d0d4c3c22ef9fca8c2a912d779c&jsName=quote_123&_g=0.055224825584601955";


    public String url(String param) {
        return URL;
    }

    public EmStockSumm parseResponse(String str) {
        str = StringUtils.trimLeadingCharacter(str, '(');
        str = StringUtils.trimTrailingCharacter(str, ')');
        List<String> stringList = Lists.newArrayList();
        try {
            stringList = JsonUtil.parseJsonGeneric(str, List.class, String.class);
        } catch (IOException e) {
            logger.error("summ stock list parse error, reponse:{}", str, e);
        }
        List<Stock> stockCodeList = Lists.newArrayList();
        for (String sinStr : stringList) {
            List<String> stockInfos = splitter.splitToList(sinStr);
            String stockCode = stockInfos.get(1);
            Stock stock = new Stock();
            stock.setCode(stockCode);
            stock.setNameCn(stockInfos.get(2));
            stockCodeList.add(stock);

        }
        EmStockSumm emStockSumm = new EmStockSumm();
        emStockSumm.setStockCodeList(stockCodeList);
        return emStockSumm;
    }
}
