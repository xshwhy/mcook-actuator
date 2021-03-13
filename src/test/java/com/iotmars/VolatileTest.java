package com.iotmars;

/**
 *
 * volatile 关键字 ： 当多个线程进行操作共享数据时，可以保证内存中的数据时可见的。
 *                   相当于synchronized 是一种较为轻量级的同步策略
 *
 * 注意
 *  volatile 不具备"互斥性"
 *           不能保证变量的"原子性"
 *
 * @author: xsh
 * @date: 2021/3/10 11:01
 */
public class VolatileTest {


    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        while (true) {

                if (td.isFlag()) {
                    System.out.println("------------");
                    break;
                }


        }

    }

}


class ThreadDemo implements Runnable{

    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + isFlag());
    }


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}