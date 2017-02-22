package com.ch.sa.crawl.crawl.service;

/**
 * 抓取服务
 * Created by he.chen on 5/5/16.
 */
public interface Crawler<T> {
    T fetch(String url);
    String url(String param);
    T parseResponse(String str);
}
