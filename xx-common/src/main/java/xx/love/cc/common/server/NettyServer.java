package xx.love.cc.common.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @Description
 * @Author xhy
 * @Date 2024/3/2
 */
public class NettyServer {

    private ServerBootstrap serverBootstrap;
    private int port;

    public void initNetty(int port, ChannelInitializer<SocketChannel> channelInitializer) {
        this.port = port;
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //默认参数的线程数会是系统最大可用cpu*2
        EventLoopGroup workGroup = new NioEventLoopGroup();
        // server 启动引导
        serverBootstrap = new ServerBootstrap();
        // 配置启动的参数
        serverBootstrap.group(bossGroup, workGroup)
                // 设置非阻塞IO,用它来建立新accept的连接,用于构造ServerSocketChannel的工厂类
                .channel(NioServerSocketChannel.class)
                // 临时存放已完成三次握手的请求的队列的最大长度，如果大于队列的最大长度，请求会被拒绝
                // 默认值window是200其他系统是128。
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_RCVBUF, 65536)
                .childOption(ChannelOption.SO_SNDBUF, 65536)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(channelInitializer);
    }

    public void start() {
        try {
            ChannelFuture serverChannelFuture = serverBootstrap.bind(this.port).sync();
            serverChannelFuture.channel().closeFuture().addListener(ChannelFutureListener.CLOSE);
        } catch (Exception e) {
            System.out.println("netty启动失败 " + e);
        }

    }
}
