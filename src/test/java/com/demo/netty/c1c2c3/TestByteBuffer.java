package com.demo.netty.c1c2c3;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName TestByteBuffer
 * @Author WuWenL0
 * @Date 2023-04-11 10:47
 */
@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while(true){
                int len = channel.read(buffer);
                log.debug("读取到的字节数 {}", len);
                if (len == -1){
                    break;
                }
                buffer.flip();
                while(buffer.hasRemaining()){
                    byte b = buffer.get();
                    log.debug("实际字节 {}", (char) b);
                }
                buffer.clear();
            }
        } catch (IOException e) {
        }
    }
}
