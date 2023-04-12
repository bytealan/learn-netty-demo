package com.demo.netty.c1;

import java.nio.ByteBuffer;

/**
 * @ClassName TestByteBufferRead
 * @Author WuWenL0
 * @Date 2023-04-12 10:37
 */
public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});
        buffer.flip();

//        buffer.get(new byte[4]); // 从头开始读
//        debugAll(buffer);
//        buffer.rewind();
//        debugAll(buffer);

        // mark & reaet
        // mark 做一个标记，记录positon位置
        // reset是讲position重置到mark位置

        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
        buffer.mark(); // 标记
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
        buffer.reset(); // 重置到标记位置
        System.out.println((char) buffer.get());


    }
}
