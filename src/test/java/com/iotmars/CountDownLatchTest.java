package com.iotmars;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch : 闭锁 在完成某些运算时，只有其他所有线程的运算全部完成，当前运算才继续执行
 *
 *
 * @author: xsh
 * @date: 2021/3/12 13:28
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);

        LatchDemo latchDemo = new LatchDemo(latch);

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {

            new Thread(latchDemo).start();

        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();


        System.out.println("耗费时间" + (end- begin));

    }

}


class LatchDemo implements Runnable {

    private CountDownLatch latch;


    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        synchronized (this) {
            try {
                for (int i = 0; i < 50000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();
            }
        }



    }
}