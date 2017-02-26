package com.ch.sa.crawl.bean.qqstock;

import java.io.Serializable;

/**
 * Created by he.chen on 2/26/17.
 */
public class QQCategory implements Serializable{
    /**
     * 名字
     */
    private String name;
    /**
     * id
     */
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
