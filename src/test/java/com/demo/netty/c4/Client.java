package com.demo.netty.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @ClassName Client
 * @Author WuWenL0
 * @Date 2023-04-17 14:07
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",8080));
        SocketAddress address = sc.getLocalAddress();
//        sc.write(Charset.defaultCharset().encode("hello\nworld\n"));
        sc.write(Charset.defaultCharset().encode("0123456789abcdef3333\n"));
        sc.write(Charset.defaultCharset().encode("0123456789abcdef33330123456789abcdef3333\n"));
        System.in.read();
    }
}
