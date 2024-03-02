package xx.love.cc.gameserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author xhy
 * @Date 2024/3/2
 */
@Component
@ConfigurationProperties(prefix = "server-config")
@Data
public class ServerConfig {
    private int nettyPort;
}
