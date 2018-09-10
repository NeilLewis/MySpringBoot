package com.example.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandlerextends extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf msg){
        byte[] buffer = new byte[msg.readableBytes()];
        msg.readBytes(buffer);

        System.out.println("server receive message :"+ msg);
        ctx.channel().writeAndFlush("yes server already accept your message" + msg);
        //ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接");
    }
}
