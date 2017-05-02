package com.ch.sa.crawl.bean;

import com.ch.sa.crawl.bean.qqstock.QQDayPrice;

import java.io.Serializable;
import java.util.List;

/**
 * Created by he.chen on 4/4/17.
 */
public class QtStock implements Serializable {

    private QQDayPrice dayPrice;
    private String code;
    private String name;
    private List<String> concepts;

    public QQDayPrice getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(QQDayPrice dayPrice) {
        this.dayPrice = dayPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<String> concepts) {
        this.concepts = concepts;
    }
}
