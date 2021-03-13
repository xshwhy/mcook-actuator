package com.iotmars;

import java.util.ArrayList;
import java.util.List;
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
public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        ThreadPoolDemo tpd = new ThreadPoolDemo();

        List<Future<Integer>> list = new ArrayList<>();




        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 0; i <= 100; i++) {
                        sum += i;
                    }
                    return sum;
                }
            });
            list.add(future);

        }
        pool.shutdown();

        for (Future<Integer> future : list) {
            System.out.println(future.get());
        }

       /* // 为线程池中线程分配任务
        for (int i = 0; i < 10; i++) {
            pool.submit(tpd);
        }

        // 关闭线程池
        pool.shutdown();*/

    }

}


class ThreadPoolDemo implements Runnable {

    private int i = 0;

    @Override
    public void run() {
        while (i <= 100) {
            System.out.println(Thread.currentThread().getName()
                    + " : " + i++);
        }
    }
}
