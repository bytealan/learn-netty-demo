package com.demo.netty.c1;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static com.demo.netty.c1.ByteBufferUtil.debugAll;

/**
 * @ClassName TestByteBufferString
 * @Author WuWenL0
 * @Date 2023-04-12 11:10
 */
public class TestByteBufferString {
    public static void main(String[] args) {
        /**
         * 字符串转为ByteBuffer
         */
        // 1. put
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes(StandardCharsets.UTF_8));
        debugAll(buffer);

        // 2. charset - 自动切换读模式
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("hello");
        debugAll(buffer2);

        // 3. wrap - 自动切换读模式
        ByteBuffer buffer3 = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));
        debugAll(buffer3);

        /**
         * ByteBuffer转为字符串
         */
        String str1 = StandardCharsets.UTF_8.decode(buffer2).toString();
        System.out.println(str1);

        buffer.flip();
        String str2 = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println(str2);
    }
}
