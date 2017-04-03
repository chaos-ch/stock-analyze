package com.ch.sa.crawl.crawl.service;

import com.ch.base.lang.serial.JsonUtil;
import com.ch.sa.crawl.bean.qqstock.QQResponse;
import com.ch.sa.crawl.bean.qqstock.QQStockBaseInfo;
import com.ch.sa.crawl.bean.qqstock.QQStockBaseInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * crawler for price data
 * Created by he.chen on 5/5/16.
 */
@Service("qQStockInfoCrawler")
public class QQStockInfoCrawler extends AbstractCrawler<QQStockBaseInfoResponse> {

    private static final Logger logger = LoggerFactory.getLogger(QQStockInfoCrawler.class);

    private static final String QQ_BASE_INFO_URL = "http://123.126.122.40/ifzqgtimg/stock/corp/cwbb/search?type=sum&num=4&jianjie=1&r=58944&_rndtime=1487655999&_appName=ios&_dev=iPhone7,2&_devId=fbfbe8f77100ac7c021ea581123166627829f41c&_appver=5.1.1&_ifChId=&_isChId=1&_osVer=10.2.1&_uin=510962552&_wxuin=510962552&symbol={0}";


    public String url(String code) {

        return MessageFormat.format(QQ_BASE_INFO_URL, code);
    }

    public QQStockBaseInfoResponse parseResponse(String str) {
        try {
            return JsonUtil.parseJson(str, QQStockBaseInfoResponse.class);
        } catch (IOException e) {
            logger.error("baidu stock parse json ");
        }
        return null;
    }




}
