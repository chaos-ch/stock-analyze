/*
 * Copyright (c) 2017. tdc.shangri-la.com. All Rights Reserved.
 */

package com.ch.sa.crawl.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author CH created on 17/06/2017
 * @version $Id$
 * 搜索查询
 */
public class SearchQuery implements Serializable {
    /**
     * 概念,逗号分割
     */
    private String concepts;
    private BigDecimal zhangfu;

    public String getConcepts() {
        return concepts;
    }

    public void setConcepts(String concepts) {
        this.concepts = concepts;
    }

    public BigDecimal getZhangfu() {
        return zhangfu;
    }

    public void setZhangfu(BigDecimal zhangfu) {
        this.zhangfu = zhangfu;
    }
}
