package com.iotmars;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 使用NIO 完成网络通信的三个核心
 *
 * 1 通道 (Channel) 负责连接
 *
 *   java.nio.channels.Channel 接口
 *          -- SelectableChannel
 *          -- SocketChannel
 *          -- ServerSocketChannel
 *          -- DatagramChannel
 *
 *          --Pipe.SinkChannel
 *          --Pipe.SourChannel
 *
 *
 * 2 缓冲区 (Buffer) 负责数据的存取
 *
 * 3 选择器 (Selector) 是SelectableChannel 的多路复用器。
 *      用于监控 SelectableChannel 的IO状况
 *
 * @author: xsh
 * @date: 2021/3/9 15:47
 */
public class BlockingNIOTest {

    // 客户端
    @Test
    void client() throws IOException {
        // 1 获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"),StandardOpenOption.READ);



        // 2 分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 3 从本地读取图片并发送到服务端去
        while (inChannel.read(buf) != -1) {
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        // 关闭通道

        inChannel.close();
        sChannel.close();
    }

    // 服务端
    @Test
    void server() throws IOException {

        // 获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        // 绑定连接
        ssChannel.bind(new InetSocketAddress(9898));

        // 获取客户端连接的通道

        SocketChannel sChannel = ssChannel.accept();

        // 分配一个指定大小的缓冲区

        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 接受客户端的数据并保存到本地
        while (sChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        sChannel.close();
        outChannel.close();
        ssChannel.close();
    }


    // 客户端
    @Test
    void client2() throws IOException {
        // 1 获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"),StandardOpenOption.READ);



        // 2 分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 3 从本地读取图片并发送到服务端去
        while (inChannel.read(buf) != -1) {
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        // 客户端发送完成
        sChannel.shutdownOutput();


        int len = 0;
        while ((len = sChannel.read(buf)) != -1) {
            buf.flip();
            System.out.println(new String(buf.array(),0,len));
            buf.clear();
        }

        // 关闭通道

        inChannel.close();
        sChannel.close();
    }

    // 服务端
    @Test
    void server2() throws IOException {

        // 获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        // 绑定连接
        ssChannel.bind(new InetSocketAddress(9898));

        // 获取客户端连接的通道

        SocketChannel sChannel = ssChannel.accept();

        // 分配一个指定大小的缓冲区

        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 接受客户端的数据并保存到本地
        while (sChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        buf.put("服务端接受数据成功".getBytes());
        buf.flip();
        sChannel.write(buf);

        sChannel.close();
        outChannel.close();
        ssChannel.close();
    }

    // 客户端
    @Test
    void client3() throws IOException {
        // 1 获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        //2 切换非阻塞模式
        sChannel.configureBlocking(false);

        // 3 分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String next = scanner.next();
            // 4 发送数据给服务端
            buf.put((new Date().toString() + "\n" +next).getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();

        }

        // 关闭通道
        sChannel.close();

    }

    // 服务端
    @Test
    void server3() throws IOException {

        // 获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        //2 切换非阻塞模式
        ssChannel.configureBlocking(false);

        //3 绑定连接
        ssChannel.bind(new InetSocketAddress(9898));

        //4 获取选择器
        Selector selector = Selector.open();

        //5 将通道注册到选择器上 并且指定 监听接受事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6  轮询式的获取选择器上已经转呗就绪 的事件
        while (selector.select() > 0) {

            // 7 获取当前选择器中所有注册的"选择器"(已就绪的监听事件)
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while (it.hasNext()) {

                // 8 获取准备就绪的事件
                SelectionKey sk = it.next();

                // 9 判断具体是什么事件准备就绪
                if (sk.isAcceptable()) {
                    // 10 若"接收就绪"获取客户端连接
                    SocketChannel sChannel = ssChannel.accept();

                    // 11 切换非阻塞模式
                    sChannel.configureBlocking(false);

                    // 12 将该通道注册到选择器上
                    sChannel.register(selector,SelectionKey.OP_READ);
                } else if (sk.isReadable()) {

                    // 13 获取当前选择器上 读就绪 状态的通道
                    SocketChannel sChannel = (SocketChannel) sk.channel();

                    // 14 读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    int len = 0;
                    while ((len = sChannel.read(buf)) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }

                }

                //15 取消选择键 SelectionKey
                it.remove();



            }



        }


    }


    @Test
    public void send() throws IOException{
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()){
            String str = scan.next();
            buf.put((new Date().toString() + ":\n" + str).getBytes());
            buf.flip();
            dc.send(buf, new InetSocketAddress("127.0.0.1", 9898));
            buf.clear();
        }

        dc.close();
    }

    @Test
    public void receive() throws IOException{
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);

        dc.bind(new InetSocketAddress(9898));

        Selector selector = Selector.open();

        dc.register(selector, SelectionKey.OP_READ);

        while(selector.select() > 0){
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while(it.hasNext()){
                SelectionKey sk = it.next();

                if(sk.isReadable()){
                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    dc.receive(buf);
                    buf.flip();
                    System.out.println(new String(buf.array(), 0, buf.limit()));
                    buf.clear();
                }
            }

            it.remove();
        }
    }

    @Test
    public void test1() throws IOException{
        //1. 获取管道
        Pipe pipe = Pipe.open();

        //2. 将缓冲区中的数据写入管道
        ByteBuffer buf = ByteBuffer.allocate(1024);

        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("通过单向管道发送数据".getBytes());
        buf.flip();
        sinkChannel.write(buf);

        //3. 读取缓冲区中的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(), 0, len));

        sourceChannel.close();
        sinkChannel.close();
    }

}
