package com.ch.sa.crawl.price;

import com.ch.sa.crawl.bean.SearchQuery;

/**
 * @author CH created on 18/06/2017
 * @version $Id$
 */
public interface StockBizService {
    Object zhangtingConcept(int newStock);
    Object search(SearchQuery query);
}
