package com.demo.netty.c1;

import java.nio.ByteBuffer;

/**
 * @ClassName TestByteBufferAllocate
 * @Author WuWenL0
 * @Date 2023-04-12 10:16
 */
public class TestByteBufferAllocate {
    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(16).getClass()); // 堆内存- 读写效率较低，受到 GC 影响
        System.out.println(ByteBuffer.allocateDirect(16).getClass()); // 直接内存 - 读写效率搞（少一次拷贝），不会受到 GC 影响, 分配的效率低
    }
}
