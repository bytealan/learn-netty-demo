package com.demo.netty.c1c2c3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @ClassName TestFileChannelTransferTo
 * @Author WuWenL0
 * @Date 2023-04-12 14:29
 */
public class TestFileChannelTransferTo {
    public static void main(String[] args) {
        try (FileChannel from = new FileInputStream("data.txt").getChannel();
             FileChannel to = new FileOutputStream("to.txt").getChannel()) {
            // 效率高，底层会利用零拷贝进行优化，2G
            long size = from.size();
            for (long left = size; left>0;){
                left -= from.transferTo(size - left, left, to);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
