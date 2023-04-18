package com.demo.netty.c1c2c3;

import java.nio.ByteBuffer;

import static com.demo.netty.c1c2c3.ByteBufferUtil.debugAll;

/**
 * @ClassName TestByteBufferReadWrite
 * @Author WuWenL0
 * @Date 2023-04-11 14:00
 */
public class TestByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 0x61); // 'a'
        debugAll(buffer);
        buffer.put(new byte[]{0x62, 0x63, 0x64}); // 'b' 'c' 'd'
        debugAll(buffer);
        buffer.flip();
        System.out.println(buffer.get());
        debugAll(buffer);
        buffer.compact();
        debugAll(buffer);
        buffer.put(new byte[]{0x65, 0x66});
        debugAll(buffer);
    }
}
