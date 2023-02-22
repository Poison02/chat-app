package com.cdu.chatappapi;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ChatAppApiApplication implements CommandLineRunner {
    @Autowired
    SocketIOServer socketIOServer;

    public static void main(String[] args) {
        SpringApplication.run(ChatAppApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 启动socketIOServer服务器
        socketIOServer.start();
    }
}
