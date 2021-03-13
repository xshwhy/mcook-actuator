package com.iotmars;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一 i++ 的原子性问题  i++ 实际上分为三个步骤 读 改 写
 *         int i  = 10;
 *         i = i++;
 *
 *         int temp = i;
 *         i = i+ 1;
 *         i = temp;
 *
 * 二 原子变量： jdk1.5 后 java.util.concurrent.atomic 包下提供了常用的原子变量
 *              1 volatile 内存可见性
 *              2 CAS(Compare-And-Swap) 无锁的非阻塞算法 保证数据的原子性
 *                      CAS 硬件对于并发操作共享数据的支持
 *                      CAS 包含三个操作数
 *                      内存值 V
 *                      预估值 A
 *                      更新值 B
 *                      当且仅当 V == A 时，V = B ，否则不做任何操作
 *
 * @author: xsh
 * @date: 2021/3/10 17:25
 */
public class AtomicTest {


    public static void main(String[] args) {

        Atomic atomic = new Atomic();

        for (int i = 0; i < 10; i++) {
            new Thread(atomic).start();
        }


    }


}


class Atomic implements Runnable {


//    private volatile int serialNumber =  0;
    private AtomicInteger serialNumber =  new AtomicInteger();

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+":" +getSerialNumber());

    }

    public int getSerialNumber() {
        return  serialNumber.getAndIncrement();
    }



}

