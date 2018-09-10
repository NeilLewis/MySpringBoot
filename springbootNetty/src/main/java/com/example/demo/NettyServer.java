package com.example.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Component
public class NettyServer {

    private static final Logger log = Logger.getLogger(NettyServer.class);

    private final EventLoopGroup bossGroup = new NioEventLoopGroup();
    private final EventLoopGroup workerGroup = new NioEventLoopGroup();

    private Channel channel;

    /**
     * 启动服务
     */
    public ChannelFuture run (InetSocketAddress address) {

        ChannelFuture f = null;
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                          @Override
                          protected void initChannel(SocketChannel ch) throws Exception {
                              ChannelPipeline pipeline = ch.pipeline();
                              pipeline.addLast(new ServerHandlerextends());
                          }
                      });

            f = b.bind(address).syncUninterruptibly().sync();
            channel = f.channel();
        } catch (Exception e) {
            log.error("Netty start error:", e);
        } finally {
            if (f != null && f.isSuccess()) {
                log.info("Netty server listening " + address.getHostName() + " on port " + address.getPort() + " and ready for connections...");
            } else {
                log.error("Netty server start up Error!");
            }
        }

        return f;
    }

    public void destroy() {
        log.info("Shutdown Netty Server...");
        if(channel != null) { channel.close();}
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
        log.info("Shutdown Netty Server Success!");
    }
}

