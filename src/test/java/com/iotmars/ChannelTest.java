package com.iotmars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * 一 通道(Channel) : 用于源节点与目标节点的连接。在java NIO 中负责缓冲区中数据的传输。
 * Channel 本身不存储数据，因此需要配合缓冲区进行传输
 * <p>
 * 二 通道的一些主要实现类
 * java.nio.channels.Channel 接口：
 * --FileChannel
 * --SocketChannel
 * --ServerSocketChannel
 * --DatagramChannel
 * <p>
 * 三 获取通道
 * 1 java 针对支持通道的类提供了getChannel()方法
 * 本地 IO:
 * FileInputStream/  FileOutputStream
 * RandomAccessFile
 * <p>
 * 网络IO:
 * Socket
 * ServerSocket
 * DatagramSocket
 * <p>
 * 2 jdk1.7中的NIO.2 针对各个通道提供了静态方法open()
 * 3 jdk1.7中的NIO.2 的Files 工具类的newByteChannel()
 *
 * 四 通道之间的数据传输
 * transferForm()
 * transferTo()
 *
 * 五 分散(Scatter) 与聚集 (Gather)
 * 分散读取(Scattering Reads) : 将通道中的数据分散到多个缓冲区中
 * 聚集写入(Gathering Writer) : 将多个缓冲区中的数据聚集到通道中
 *
 * 六 字符集: Charset
 *  编码：字符串-> 字节数组
 *  解码：字节数组 -> 字符串
 *
 *
 * @author: xsh
 * @date: 2021/3/8 13:28
 */
@DisplayName("通道")
public class ChannelTest {


    // 利用通道完成文件的复制  非直接缓冲区
    @Test
    public void test01() {
        long beginTime = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("1.mp4");
            fos = new FileOutputStream("2.mp4");

            // 获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            // 分配一个指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            // 将通道中的数据存入缓冲区中
            while (inChannel.read(buf) != -1) {
                buf.flip(); // 切换读取数据饿模式
                // 将缓冲区中数据写入通道中
                outChannel.write(buf);
                buf.clear(); // 清空缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (fis != null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }

        long endTime = System.currentTimeMillis();

        System.out.println("耗费时间" + (endTime- beginTime));


    }

    // 使用直接缓冲区 完成文件的复制 内存映射文件
    @Test
    public void test02() throws IOException {

        long beginTime = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("1.mp4"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.mp4"), StandardOpenOption.WRITE,
                StandardOpenOption.READ,StandardOpenOption.CREATE);

        // 内存映射文件
        MappedByteBuffer inMapByteBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapByteBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        // 直接对缓冲区进行数据的读写操作
        byte [] dst = new byte[inMapByteBuf.limit()];
        inMapByteBuf.get(dst);
        outMapByteBuf.put(dst);

        inChannel.close();
        outChannel.close();
        long endTime = System.currentTimeMillis();

        System.out.println("耗费时间" + (endTime- beginTime));

    }


    // 通道之间的数据传输(直接传输)
    @Test
    public void test03() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.mp4"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.mp4"), StandardOpenOption.WRITE,
                StandardOpenOption.READ,StandardOpenOption.CREATE);

//        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    @Test
    public void test04() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("1.txt", "rw");
        // 获取通道
        FileChannel channel1 = raf1.getChannel();

        // 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);

        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        // 分散读取
        ByteBuffer[] bufs = {buf1,buf2};

        channel1.read(bufs);

        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();
        }

        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("===================");
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));

        RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);
    }

    @Test
    public void test05() {
        String s1 = "back:menu:1";
        String s2 = "back:menu:2";
        String s3 = "back:menu:3";
        String []  str = new String[]{s1,s2,s3};
        String s = StringUtils.arrayToDelimitedString(str, "','");
        System.out.println(s);

        String s4 = "back:menu:1,back:menu:2,back:menu:3";
        String []  str1 = new String[]{s4};

        String s5 = StringUtils.arrayToDelimitedString(str1, "','");

        System.out.println(s5);


    }

    // 字符集
    @Test
    void test06() {
        Map<String, Charset> map = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> entries = map.entrySet();

        for (Map.Entry<String, Charset> entry : entries) {

            System.out.println(entry.getKey() + "=" + entry.getValue());

        }


    }


    @Test
    void test07() throws CharacterCodingException {

        Charset gbk = Charset.forName("GBK");
        // 获取编码器
        CharsetEncoder ce = gbk.newEncoder();
        // 获取解码器
        CharsetDecoder cd = gbk.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("尚硅谷牛逼！");
        cBuf.flip();

        // 编码
        ByteBuffer encode = ce.encode(cBuf);


        for (int i = 0; i < 12; i++) {
            System.out.println(encode.get());
        }
        encode.flip();
        CharBuffer decode = cd.decode(encode);

        System.out.println(decode);

        Charset cs1 = Charset.forName("UTF-8");
        encode.flip();
        CharBuffer decode1 = cs1.decode(encode);
        System.out.println(decode1.toString());


    }


}
