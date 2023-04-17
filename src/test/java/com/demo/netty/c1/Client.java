package com.demo.netty.c1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @ClassName Client
 * @Author WuWenL0
 * @Date 2023-04-17 14:07
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",8080));
        System.out.println("waiting...");
    }
}
