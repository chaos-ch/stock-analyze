package com.ch.sa.crawl.store.dao;

import com.ch.sa.crawl.bean.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by he.chen on 5/6/16.
 */
@Repository
public interface StockInfoDao {
    List<Stock> queryAllStock();
    int saveSumm(List<Stock> stockList);
}
