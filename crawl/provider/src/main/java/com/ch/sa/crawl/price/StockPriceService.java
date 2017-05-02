package com.ch.sa.crawl.price;

import com.ch.sa.crawl.store.bean.PriceData;
import com.ch.sa.crawl.store.dao.StockPriceDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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


    /**
     * 保存日线价格
     * @param priceData priceData
     */
    public void saveDayPrice(PriceData priceData) {
        stockPriceDao.saveDailyPrice(priceData.getCode(), priceData.getData(), priceData.getDate());

    }

    public List<PriceData> queryDailyPrice(String code, Date begin, Integer limit) {
        return stockPriceDao.selectDailyPrice(code, begin, limit);
    }

}
