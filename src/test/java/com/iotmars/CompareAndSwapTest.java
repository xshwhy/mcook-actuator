package com.iotmars;

/**
 * 模拟cas算法
 *
 * @author: xsh
 * @date: 2021/3/11 10:08
 */
public class CompareAndSwapTest {


    public static void main(String[] args) {
       final CompareAndSwap cas = new CompareAndSwap();


        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int exceptValue = cas.get();
                boolean b = cas.compareAndSet(exceptValue, (int) (Math.random() * 101));
                System.out.println(b);
            }).start();
        }


    }



}

class CompareAndSwap {
    private int value;

    // 获取内存值
    public synchronized int get() {
        return value;
    }

    // 比较
    public synchronized int compareAndSwap(int exceptValue,int newValue) {
        int oldValue = value;

        if (oldValue == exceptValue) {
            this.value = newValue;
        }

        return oldValue;
    }

    // 设置
    public synchronized boolean compareAndSet(int exceptValue,int newValue) {
        return exceptValue == compareAndSwap(exceptValue, newValue);
    }
}
