package com.ch.sa.crawl.price;

import com.ch.sa.crawl.bean.QtStock;
import com.ch.sa.crawl.bean.QuantizationStock;
import com.ch.sa.crawl.bean.Stock;
import com.ch.sa.crawl.bean.ZhangtingConcept;
import com.ch.sa.crawl.bean.qqstock.QQCategory;
import com.ch.sa.crawl.bean.qqstock.QQDayPrice;
import com.ch.sa.crawl.bean.qqstock.QQStockBaseInfo;
import com.ch.sa.crawl.store.bean.PriceData;
import com.ch.sa.crawl.util.JsonUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * stock biz
 * Created by he.chen on 4/4/17.
 */
@Service
public class StockBizService {

    @Resource
    private StockPriceService priceService;
    @Resource
    private StockInfoService stockInfoService;

    private static final BigDecimal THRESHOLD = new BigDecimal("7");

    public Object zhangtingConcept(int newStock) {

        List<PriceData> priceDataLast = priceService.queryDailyPrice(null, null, 1);
        Date date = priceDataLast.get(0).getDate();
        List<PriceData> priceDatas = priceService.queryDailyPrice(null, DateUtils.addHours(date, -2), null);
        QuantizationStock stock = new QuantizationStock();
        if (CollectionUtils.isEmpty(priceDatas)) {
            return stock;
        }

        List<Stock> stockAll = stockInfoService.queryAll();
        Map<String, Stock> stockMap = Maps.newHashMap();
        for (Stock stock1 : stockAll) {
            stockMap.put(stock1.getCode(), stock1);
        }

        List<QtStock> qtStockList = Lists.newArrayList();
        for (PriceData data : priceDatas) {
            try {
                QQDayPrice qqDayPrice = JsonUtil.parseJson(data.getData(), QQDayPrice.class);
                BigDecimal pricePercent = qqDayPrice.getPricePercent();
                if (pricePercent == null || pricePercent.compareTo(THRESHOLD) < 0) {
                    continue;
                }
                QQStockBaseInfo baseInfo = stockInfoService.queryBaseInfo(data.getCode());

                QtStock qtStock = new QtStock();
                qtStock.setDayPrice(qqDayPrice);
                Stock stockSum = stockMap.get(data.getCode());
                qtStock.setCode(stockSum.getCode());
                qtStock.setName(stockSum.getNameCn());
                List<QQCategory> conceptQQ = baseInfo.getGegu().getConcept();
                List<String> concepts = Lists.newArrayList();
                for (QQCategory category : conceptQQ) {
                    concepts.add(category.getName());
                }
                qtStock.setConcepts(concepts);
                if (newStock == 0 && concepts.contains("新股次新股")) {
                    continue;
                }
                qtStockList.add(qtStock);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(qtStockList, new Comparator<QtStock>() {
            public int compare(QtStock o1, QtStock o2) {
                return o2.getDayPrice().getPricePercent().compareTo(o1.getDayPrice().getPricePercent());
            }
        });
        stock.setQtStockList(qtStockList);
        stock = adaptWeb(stock);
        return stock;



    }

    private QuantizationStock adaptWeb(QuantizationStock stock) {
        stock.setZhangtingConceptList(adaptZtConcept(stock, new BigDecimal("9.97")));
        stock.setHotConceptList(adaptZtConcept(stock, null));

        return stock;
    }

    private List<ZhangtingConcept> adaptZtConcept(QuantizationStock stock, BigDecimal thr) {

        List<ZhangtingConcept> zhangtingConcepts = Lists.newArrayList();

        if (stock == null || CollectionUtils.isEmpty(stock.getQtStockList())) {
            return zhangtingConcepts;
        }
        List<QtStock> qtStockList = stock.getQtStockList();
        Map<String, Integer> conceptMap = Maps.newHashMap();
        for (QtStock qtStock : qtStockList) {
            if (thr != null && qtStock.getDayPrice().getPricePercent().compareTo(thr) < 0 ) {
                continue;
            }
            for (String concept : qtStock.getConcepts()) {
                conceptMap.put(concept, (conceptMap.get(concept) == null ? 1 : conceptMap.get(concept)) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : conceptMap.entrySet()) {
            ZhangtingConcept zt = new ZhangtingConcept();
            zt.setName(entry.getKey());
            zt.setValue(entry.getValue());
            zhangtingConcepts.add(zt);
        }

        Collections.sort(zhangtingConcepts, new Comparator<ZhangtingConcept>() {
            public int compare(ZhangtingConcept o1, ZhangtingConcept o2) {
                return Integer.valueOf(o2.getValue()).compareTo(Integer.valueOf(o1.getValue()));
            }
        });
        int size = zhangtingConcepts.size();
        if (size > 20) {
            zhangtingConcepts = zhangtingConcepts.subList(0, 20);
        }
        return zhangtingConcepts;
    }
}
