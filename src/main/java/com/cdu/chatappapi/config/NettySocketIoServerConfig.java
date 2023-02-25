package com.cdu.chatappapi.config;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class NettySocketIoServerConfig {
    /**
     * 创建一个SocketIOServer服务器实例
     * @return socketIOServer
     */
    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        config.setHostname("localhost"); // 192.168.161.163  175.24.183.52
        config.setPort(8081);
        // 开放跨域设置
        config.setOrigin(null);

        SocketIOServer socketIOServer = new SocketIOServer(config);
        return socketIOServer;
    }

    /**
     * 用于扫描netty socketIo的注解，如@OnConnect、@OnEvent
     */
    @Bean
    public SpringAnnotationScanner springAnnotationScanner() {
        return new SpringAnnotationScanner(socketIOServer());
    }
}
