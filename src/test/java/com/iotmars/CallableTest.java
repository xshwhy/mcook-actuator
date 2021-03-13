package com.iotmars;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建执行线程的方式三 实现Callable 接口 相较于实现Runnable
 * 接口的方式，方法可以有返回值，并且可以抛出异常
 *
 * 执行Callable 方式，需要FutureTask 实现类的支持，FutureTask 是Future 接口的实现类
 *
 * @author: xsh
 * @date: 2021/3/12 13:44
 */
public class CallableTest {

    public static void main(String[] args) {
        ThreadS td = new ThreadS();

        FutureTask<Integer> result = new FutureTask<Integer>(td);

        new Thread(result).start();



        // 接收线程运算后的结果
        try {
            // FutureTask 也可用于闭锁
            Integer sum = result.get();

            System.out.println("结果"+sum);

            System.out.println("===========");
        } catch (InterruptedException | ExecutionException  e) {
            e.printStackTrace();
        }



    }



}

class ThreadS implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;

        for (int i = 0; i <= Integer.MAX_VALUE; i++) {

            System.out.println(i);

            sum += i;

        }


        return sum;
    }
}



/*class ThreadDemo implements Runnable {


    @Override
    public void run() {

    }
}*/



