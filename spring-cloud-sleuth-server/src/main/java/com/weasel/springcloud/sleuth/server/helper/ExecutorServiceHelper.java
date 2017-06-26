package com.weasel.springcloud.sleuth.server.helper;

import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.*;

/**
 * @author dylan
 * @time 2017/6/14
 */
public final class ExecutorServiceHelper {

    public static ExecutorService newCachedThreadPool(){
        return wrapExecutorService(Executors.newCachedThreadPool());
    }
    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory){
        return wrapExecutorService(Executors.newCachedThreadPool(threadFactory));
    }
    public static ExecutorService newFixedThreadPool(int threads){
        return wrapExecutorService(Executors.newFixedThreadPool(threads));
    }
    public static ExecutorService newFixedThreadPool(int threads,ThreadFactory threadFactory){
        return wrapExecutorService(Executors.newFixedThreadPool(threads,threadFactory));
    }

    public static ExecutorService newSingleThreadExecutor(){
        return wrapExecutorService(Executors.newSingleThreadExecutor());
    }
    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory){
        return wrapExecutorService(Executors.newSingleThreadExecutor(threadFactory));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(){
        return wrapScheduledExecutorService(Executors.newSingleThreadScheduledExecutor());
    }
    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory){
        return wrapScheduledExecutorService(Executors.newSingleThreadScheduledExecutor(threadFactory));
    }
    public static ScheduledExecutorService newScheduledThreadPool(int threads){
        return wrapScheduledExecutorService(Executors.newScheduledThreadPool(threads));
    }
    public static ScheduledExecutorService newScheduledThreadPool(int threads,ThreadFactory threadFactory){
        return wrapScheduledExecutorService(Executors.newScheduledThreadPool(threads,threadFactory));
    }

    public static Executor wrapExecutor(Executor executor){
        return TtlExecutors.getTtlExecutor(executor);
    }
    public static ExecutorService wrapExecutorService(ExecutorService executorService){
        return TtlExecutors.getTtlExecutorService(executorService);
    }
    public static ScheduledExecutorService wrapScheduledExecutorService(ScheduledExecutorService scheduledExecutorService){
        return TtlExecutors.getTtlScheduledExecutorService(scheduledExecutorService);
    }

    private ExecutorServiceHelper(){}
}
