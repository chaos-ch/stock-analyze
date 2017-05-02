package com.ch.sa.crawl.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by he.chen on 4/4/17.
 */
public class QuantizationStock implements Serializable {

    private List<QtStock> qtStockList;

    private List<ZhangtingConcept> zhangtingConceptList;
    private List<ZhangtingConcept> hotConceptList;
    public List<QtStock> getQtStockList() {
        return qtStockList;
    }

    public void setQtStockList(List<QtStock> qtStockList) {
        this.qtStockList = qtStockList;
    }

    public List<ZhangtingConcept> getZhangtingConceptList() {
        return zhangtingConceptList;
    }

    public void setZhangtingConceptList(List<ZhangtingConcept> zhangtingConceptList) {
        this.zhangtingConceptList = zhangtingConceptList;
    }

    public List<ZhangtingConcept> getHotConceptList() {
        return hotConceptList;
    }

    public void setHotConceptList(List<ZhangtingConcept> hotConceptList) {
        this.hotConceptList = hotConceptList;
    }
}
