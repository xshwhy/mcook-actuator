package com.iotmars;

/**
 * 题目 打印输出 one two ?
 *
 * 1 两个普通同步方法，两个线程标准打印，打印？ // one two
 * 2 新增Thread.sleep() 给getOne() 打印 ？ // one two
 * 3 新增普通getThree() ,打印？ // three one two
 * 4 两个普通同步方法，两个Number对象,打印？ // two  one
 * 5 修改getOne() 为静态同步方法，打印？ // two one
 * 6 修改两个方法均为静态同步方法，一个Number对象？ 打印 one two
 * 7 一个是静态同步方法，一个是非静态同步方法，两个Number 对象？ // two one
 * 8 两个静态同步方法，两个Number对象？ // one two
 *
 *
 * 线程八锁的关键：
 * 非静态方法的锁默认为 this, 静态方法的锁 为 对应的Class 实例
 * 某一时刻内，只能有一个线程持有锁，无论几个方法
 *
 *
 * @author: xsh
 * @date: 2021/3/13 9:09
 */
public class Thread8MonitorTest {

    public static void main(String[] args) {
        Number number = new Number();
//        Number number2 = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Number.getOne();
            }
        }).start();
        new Thread(Number::getTwo).start();
//        new Thread(number::getThree).start();

    }

}


class Number {

    public static synchronized void getOne() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static  synchronized void getTwo() {
        System.out.println("two");
    }

    public  void getThree() {
        System.out.println("three");
    }


}
