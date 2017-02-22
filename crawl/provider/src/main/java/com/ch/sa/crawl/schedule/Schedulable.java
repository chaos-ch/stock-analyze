package com.ch.sa.crawl.schedule;

/**
 * 可被调度
 * Created by he.chen on 5/4/16.
 */
public interface Schedulable {
    /**
     * 执行方法
     */
    void execute();

    String cron();
}
