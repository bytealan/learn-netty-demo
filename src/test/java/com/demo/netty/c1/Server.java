package com.demo.netty.c1;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.demo.netty.c1.ByteBufferUtil.debugRead;

/**
 * @ClassName Server
 * @Author WuWenL0
 * @Date 2023-04-17 13:58
 */
@Slf4j
public class Server {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(16);

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(8080));
        List<SocketChannel> channels = new ArrayList<>();

        while(true){
//            log.debug("连接中...");
            SocketChannel sc = ssc.accept();
            if (Objects.nonNull(sc)){
                log.debug("已连接... {}", sc);
                sc.configureBlocking(false);
                channels.add(sc);
            }
            for (SocketChannel channel : channels) {
//                log.debug("读取数据之前... {}", channel);
                int read = channel.read(buffer);
                if (read > 0 ){
                    buffer.flip();
                    debugRead(buffer);
                    buffer.clear();
                    log.debug("读取数据之后... {}", channel);
                }
            }
        }
    }
}
