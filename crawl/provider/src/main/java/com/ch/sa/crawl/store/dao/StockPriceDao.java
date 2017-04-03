package com.ch.sa.crawl.store.dao;

import com.ch.sa.crawl.bean.Stock;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 数据dao
 * Created by he.chen on 5/5/16.
 */
@Repository
public interface StockPriceDao {
    void addNewPriceData(@Param("stockCode") String stockCode, @Param("data") String data, @Param("priceTime") Date priceTime);

    /**
     * 分时买卖
     * @param code code
     * @param data json data
     * @param bsTime 成交时间
     */
    void saveBSInfo(@Param("stockCode") String code, @Param("data") String data, @Param("bsTime") Date bsTime);

    /**
     * 日线价格
     * @param code code
     * @param data data json
     * @param bsTime 日期
     */
    void saveDailyPrice(@Param("stockCode") String code, @Param("data") String data, @Param("bsTime") Date bsTime);
}
