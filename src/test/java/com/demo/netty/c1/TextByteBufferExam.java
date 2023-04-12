package com.demo.netty.c1;

import java.nio.ByteBuffer;

import static com.demo.netty.c1.ByteBufferUtil.debugAll;

/**
 * @ClassName TextByteBufferExam
 * @Author WuWenL0
 * @Date 2023-04-12 13:43
 */
public class TextByteBufferExam {
    /**
     * 网络上有多条数据发送给服务端，数据之间使用 \n 进行分隔
     * 但由于某种原因这些数据在接收时，被进行了重新组合，例如原始数据有3条为
     * <p>
     * Hello,world\n
     * I'm zhangsan\n
     * How are you?\n
     * <p>
     * 变成了下面的两个 byteBuffer (黏包，半包)
     * <p>
     * Hello,world\nI'm zhangsan\nHo
     * w are you?\n
     * <p>
     * 现在要求你编写程序，将错乱的数据恢复成原始的按 \n 分隔的数据
     */
    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you?\n".getBytes());
        split(source);
    }

    private static void split(ByteBuffer source) {
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if (source.get(i) == '\n') {
                int length = i + 1 - source.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
                debugAll(target);
            }
        }
        source.compact();
    }
}
