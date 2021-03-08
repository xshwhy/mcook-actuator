package com.iotmars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * @author: xsh
 * @date: 2021/3/8 10:45
 */
@DisplayName("Nio测试")
public class NioTest {


    /**
     * 缓冲区(Buffer):在java nio中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
     * <p>
     * 根据数据类型(boolean 除外)不同，提供了相应类型的缓冲区
     * <p>
     * ByteBuffer CharBuffer ShortBuffer IntBuffer LongBuffer FloatBuffer DoubleBuffer
     * <p>
     * 上述缓冲区的管理方式几乎一致，通过 allocate()获取缓冲区
     * <p>
     * 缓冲区存取数据的两个核心方法：
     * put(): 存入数据到缓冲区中
     * get(): 获取缓冲区中的数据
     * <p>
     * 缓冲区中的四个核心属性
     * capacity：容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变
     * limit： 界限，表示缓冲区中可以操作数据的大小 (limit 后数据不能进行读取)
     * position： 位置，缓冲区中正在操作数据的位置
     * <p>
     * mark ： 标记，表示记录当前position 的位置。可以通过reset() 恢复到mark的位置
     * 0 <= mark <=  position <= limit <= capacity
     * <p>
     * 直接缓冲区与非直接缓冲区
     * 非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM的内存中
     * 直接缓冲区：通过通过allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理缓冲区中，可以提高效率
     */

    @Test
    void test03() {
        // 分配直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        System.out.println(byteBuffer.isDirect());
    }



    @Test
    void test02() {
        String str = "abcd";
        ByteBuffer buf = ByteBuffer.allocate(1024);

        buf.put(str.getBytes());
        buf.flip();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst,0,2);

        System.out.println(new String(dst,0,2));
        System.out.println(buf.position());
        // 标记位置
        buf.mark();

        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buf.position());

        // reset 恢复到mark的位置
        buf.reset();
        System.out.println(buf.position());

        // 判断缓冲区中是否还有剩余数据
        if (buf.hasRemaining()) {

            // 获取缓冲区可以操作的数据
            System.out.println(buf.remaining());
        }

    }



    @Test
    void test01() {
        String str = "abc";
        // 1 分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println("================");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        // 利用put 存储数据到缓冲区
        buf.put(str.getBytes());
        System.out.println("========put=======");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        // 读数据模式
       buf.flip();
       System.out.println("========flip=======");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println("========get=======");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        // rewind() 可重复读数据
        buf.rewind();
        System.out.println("========rewind=======");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        // 清空缓冲区,但是缓冲区中的数据依然存在，但是处于"被遗忘"的状态

        buf.clear();
        System.out.println("========clear=======");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println((char) buf.get());
    }


}
