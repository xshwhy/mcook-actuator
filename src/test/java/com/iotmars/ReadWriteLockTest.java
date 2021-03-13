package com.iotmars;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock ： 读写锁
 *
 * 写写/读写 互斥
 * 读读 不需要互斥
 *
 * @author: xsh
 * @date: 2021/3/12 17:19
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(() -> rw.set((int)(Math.random() * 101)),"写锁").start();

        for (int i = 0; i < 100; i++) {

            new Thread(rw::get,"读锁").start();
        }

    }

}


class ReadWriteLockDemo {

    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    // 读
    public void get() {
        lock.readLock().lock(); // 上锁
        try {
            System.out.println(Thread.currentThread().getName() + ":" +number);
        } finally {
            lock.readLock().unlock();  // 释放锁
        }
    }

    public void set(int number) {
        lock.writeLock().lock(); // 上锁

        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        } finally {
            lock.writeLock().unlock(); // 上锁
        }
    }

}
