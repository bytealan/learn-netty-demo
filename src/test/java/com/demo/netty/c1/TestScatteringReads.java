package com.demo.netty.c1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static com.demo.netty.c1.ByteBufferUtil.debugAll;

/**
 * @ClassName TestScatteringReads
 * @Author WuWenL0
 * @Date 2023-04-12 13:27
 */
public class TestScatteringReads {
    public static void main(String[] args) {
        try (FileChannel channel = new RandomAccessFile("words.txt", "r").getChannel()) {
            ByteBuffer b1 = ByteBuffer.allocate(3);
            ByteBuffer b2 = ByteBuffer.allocate(3);
            ByteBuffer b3 = ByteBuffer.allocate(5);

            channel.read(new ByteBuffer[]{b1, b2, b3});

            debugAll(b1);
            debugAll(b2);
            debugAll(b3);
        } catch (IOException e) {
        }
    }
}
