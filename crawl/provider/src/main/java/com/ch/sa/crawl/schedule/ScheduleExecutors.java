package com.ch.sa.crawl.schedule;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 任务调度
 * Created by he.chen on 5/4/16.
 */
@Service
public class ScheduleExecutors {

    @Autowired(required = false)
    private List<Schedulable> tasks;

    private ScheduledExecutorService  executorService = Executors.newScheduledThreadPool(3);


    public void schedule() {


    }

    public void registerTask(Schedulable task){

    }

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("123");
        list.add("124");
        list.add("125");
        Iterator<String> iterator = list.iterator();
        List<String> result = Lists.newArrayList();

        while (iterator.hasNext()) {
            String next = iterator.next();
            if (StringUtils.equals(next, "124")) {
                iterator.remove();
                result.add(next);
            }
        }

        System.out.println(result);
    }
}
