package com.ch.sa.crawl.crawl.adaptor;

import com.ch.base.lang.time.DateHelper;
import com.ch.sa.crawl.bean.StockPriceData;
import com.ch.sa.crawl.bean.baidu.BaiduPriceResponse;
import com.ch.sa.crawl.bean.baidu.BaiduStockPrice;
import com.ch.sa.crawl.store.bean.PriceData;
import com.ch.sa.crawl.store.bean.PriceDataDetail;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by he.chen on 5/11/16.
 */
@Service
public class BaiduPriceAdaptor implements Adaptor<BaiduPriceResponse, PriceData> {

    public PriceData adapt(BaiduPriceResponse from) {
        PriceData priceData = new PriceData();

        List<BaiduStockPrice> baiduPrices = from.getTimeLine();
        if (CollectionUtils.isEmpty(baiduPrices)) {
            return priceData;
        }
        for (BaiduStockPrice baiduPrice : baiduPrices) {
            PriceDataDetail detail = new PriceDataDetail();
            String time = baiduPrice.getTime();
            if (time.startsWith("9")) {
                time = "0" + time;
            }
            Date dateTime = DateHelper.parseyyyyMMddHHmmssSSS(baiduPrice.getDate() + time);
            detail.setTime(dateTime);
            detail.setAmount(baiduPrice.getAmount());
            detail.setAvgPrice(baiduPrice.getAvgPrice());
            detail.setCcl(baiduPrice.getCcl());
            detail.setNetChangeRatio(baiduPrice.getNetChangeRatio());
            detail.setPreClose(baiduPrice.getPreClose());
            detail.setPrice(baiduPrice.getPrice());
            detail.setVolume(baiduPrice.getVolume());
        }
        return priceData;
    }
}
