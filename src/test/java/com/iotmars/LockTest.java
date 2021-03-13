package com.iotmars;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用于解决多线程安全问题的方式
 *
 *  synchronized 隐式锁
 * 1 同步代码块
 *
 *
 * 2 同步方法
 *
 * jdk.5 以后
 * 3 同步锁 Lock
 *
 * 注意： 是一个显示锁，需要通过lock()方法上锁，必须通过unlock()方法进行释放锁
 *
 *
 *
 * @author: xsh
 * @date: 2021/3/12 14:10
 */
public class LockTest {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket,"1号").start();
        new Thread(ticket,"2号").start();
        new Thread(ticket,"3号").start();
    }

}

class Ticket implements Runnable {

    private int tick = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();


            try {
                if (tick > 0) {

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() +
                            "完成售票，余票为：" + --tick);
                }
            } finally {
                lock.unlock();
            }

        }

    }
}
