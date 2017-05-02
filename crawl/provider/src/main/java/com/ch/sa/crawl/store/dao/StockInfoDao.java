package com.ch.sa.crawl.store.dao;

import com.ch.sa.crawl.bean.Stock;
import com.ch.sa.crawl.bean.qqstock.QQStockBaseInfo;
import com.ch.sa.crawl.store.bean.BaseInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by he.chen on 5/6/16.
 */
@Repository
public interface StockInfoDao {
    List<Stock> queryAllStock();
    int saveSumm(List<Stock> stockList);

    int addBaseInfo(@Param("code") String code, @Param("data") String data, @Param("version") int version);

    BaseInfo queryBaseInfo(@Param("code") String code);
}
