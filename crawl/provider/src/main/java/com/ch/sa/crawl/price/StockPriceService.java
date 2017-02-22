package com.ch.sa.crawl.price;

import com.ch.sa.crawl.store.bean.PriceData;
import com.ch.sa.crawl.store.dao.StockPriceDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by he.chen on 5/11/16.
 */
@Service
public class StockPriceService {

    @Resource
    private StockPriceDao stockPriceDao;

    public void savePrice(PriceData priceData) {
        stockPriceDao.saveBSInfo(priceData.getCode(), priceData.getData(), priceData.getDate());

    }
}
