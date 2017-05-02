package com.ch.sa.crawl.bean;

import java.io.Serializable;

/**
 * Created by he.chen on 4/5/17.
 */
public class ZhangtingConcept implements Serializable {
    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
