package xx.love.cc.gameserver;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xx.love.cc.common.server.NettyServer;
import xx.love.cc.gameserver.config.ServerConfig;

/**
 * @Description
 * @Author xhy
 * @Date 2024/3/2
 */
@Component
public class GameServer {

    @Autowired
    private ServerConfig serverConfig;
    private NettyServer nettyServer;

    @PostConstruct
    private void init() {
        nettyServer = new NettyServer();
        nettyServer.initNetty(serverConfig.getNettyPort(), new ChannelInitializer<>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline()
                        .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, Integer.BYTES, 0, 4))
//                                    .addLast(new MyDecoder())
                        .addLast(new LengthFieldPrepender(Integer.BYTES));
//                                    .addLast(new MyEncoder());
                // 使用protobuf编解码器
//                                    .addLast(new ProtobufVarint32FrameDecoder())
//                                    .addLast(new ProtobufDecoder(BaseProtobufMessage.getDefaultInstance()))
//                                    .addLast(new ProtobufVarint32LengthFieldPrepender())
//                                    .addLast(new ProtobufEncoder());
//                            ch.pipeline().addLast(new GameServerIoHandler());
            }
        });

        nettyServer.start();
    }
}
