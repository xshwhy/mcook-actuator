package com.iotmars;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 一 线程池 提供线程队列 队列中保存着所有等待状态的线程
 *  避免了创建与销毁线程 提高了响应速度
 *
 * 二 线程池的体系结构
 *    java.util.concurrent.Executor : 负责线程的使用与调度的根接口
 *              -- ExecutorService 子接口: 线程池的主要接口
 *                  --  ThreadPoolExecutor 实现类 ：
 *                  -- ScheduledExecutorService 子接口： 负责线程调度的子接口
 *                      -- ScheduledThreadPoolExecutor : 继承 ThreadPoolExecutor 实现 ScheduledExecutorService
 * 三 工具类： Executor
 *  ExecutorService newFixedThreadPool() ： 创建固定大小的线程池
 *  ExecutorService newCachedThreadPool() : 缓存线程池，线程池的数量不固定，可以根据需求自动更改数量
 *  ExecutorService newSingleThreadExecutor() : 创建单个线程池，线程池只有一个线程
 *
 *  ScheduledExecutorService newScheduledThreadPool() : 创建固定大小的线程，可以延迟或定时的执行任务
 *
 *
 * @author: xsh
 * @date: 2021/3/13 9:31
 */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);


        for (int i = 0; i < 3; i++) {
            ScheduledFuture<Integer> result = pool.schedule(() -> {
                int num = new Random().nextInt(100); // 生成随机数
                System.out.println(Thread.currentThread().getName() + ":" + num);
                return num;
            }, 3, TimeUnit.SECONDS);
            System.out.println( result.get());

        }

        pool.shutdown();
    }

}


