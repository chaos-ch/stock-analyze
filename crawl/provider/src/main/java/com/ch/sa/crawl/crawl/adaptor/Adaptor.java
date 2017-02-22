package com.ch.sa.crawl.crawl.adaptor;

/**
 * Created by he.chen on 5/11/16.
 */
public interface Adaptor<F,T> {
    T adapt(F from);
}
