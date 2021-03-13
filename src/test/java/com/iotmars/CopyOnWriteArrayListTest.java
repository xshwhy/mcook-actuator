package com.iotmars;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList/CopyOnWriteArraySet : "写入并复制"
 * 注意： 添加操作多时，效率低，因为每次添加
 *
 *
 *
 * @author: xsh
 * @date: 2021/3/12 11:36
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {

        HelloThread helloThread = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(helloThread).start();
        }
    }


}

class HelloThread implements Runnable {

//    private static List<String> list = Collections.synchronizedList(new ArrayList<>());

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();


    static {
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
    }

    @Override
    public void run() {

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

            list.add("AAA");

        }





    }
}
