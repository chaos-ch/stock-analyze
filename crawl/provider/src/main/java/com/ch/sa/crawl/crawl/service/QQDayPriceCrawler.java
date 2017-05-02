package com.ch.sa.crawl.crawl.service;

import com.ch.base.lang.serial.JsonUtil;
import com.ch.sa.crawl.bean.qqstock.QQDailyPriceResponse;
import com.ch.sa.crawl.bean.qqstock.QQDayPrice;
import org.codehaus.jackson.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;

/**
 * crawler for price data
 * Created by he.chen on 5/5/16.
 */
@Service("qQDayPriceCrawler")
public class QQDayPriceCrawler extends AbstractCrawler<QQDailyPriceResponse> {

    private static final Logger logger = LoggerFactory.getLogger(QQDayPriceCrawler.class);

    private static final String QQ_DAY_PRICE_URL = "http://123.126.122.40/ifzqgtimg/appstock/app/fqkline/get?p=1&param={0},day,,,{1},qfq&_rndtime=1487656009&_appName=ios&_dev=iPhone7,2&_devId=fbfbe8f77100ac7c021ea581123166627829f41c&_appver=5.1.1&_ifChId=&_isChId=1&_osVer=10.2.1&_uin=510962552&_wxuin=510962552";


    public String url(String code) {

        return MessageFormat.format(QQ_DAY_PRICE_URL, code, 1);
    }

    public QQDailyPriceResponse parseResponse(String str) {
        try {

            JsonNode jsonNode = JsonUtil.getObjectMapperInstance().readTree(str);
            JsonNode data = jsonNode.get("data");
            Iterator<String> fieldNames = data.getFieldNames();
            String codeField = fieldNames.next();
            JsonNode info = data.get(codeField);
            JsonNode qt = info.get("qt");
            JsonNode qtPrice = qt.get(codeField);

            QQDayPrice qqDayPrice = new QQDayPrice();
            String date = qtPrice.get(30).asText();
            qqDayPrice.setDate(date);
            String openPrice = qtPrice.get(5).asText();
            qqDayPrice.setOpenPrice(openPrice);
            qqDayPrice.setClosePrice(qtPrice.get(3).asText());
            qqDayPrice.setHightPrice(qtPrice.get(33).asText());
            qqDayPrice.setLowPrice(qtPrice.get(34).asText());
            qqDayPrice.setVol(qtPrice.get(36).asText());
            qqDayPrice.setDealAmount(qtPrice.get(37).asText());
            qqDayPrice.setPricePercent(new BigDecimal(qtPrice.get(32).asText()));
            qqDayPrice.setPriceRange(new BigDecimal(qtPrice.get(31).asText()));
            qqDayPrice.setPreCLosePrice(qtPrice.get(4).asText());
            qqDayPrice.setAmplitude(new BigDecimal(qtPrice.get(43).asText()));

            QQDailyPriceResponse response = new QQDailyPriceResponse();
            response.setData(qqDayPrice);

            return response;
        } catch (IOException e) {
            logger.error("qq stock day price parse json error", e);
        }
        return null;
    }




}
