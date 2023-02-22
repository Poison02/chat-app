package com.cdu.chatappapi.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class MessageEventHandler {
    @Autowired
    SocketIOServer socketIOServer;

    // 服务端保存连接的所有对话
    public static ConcurrentMap<String, SocketIOClient> socketIOClientMap = new ConcurrentHashMap<>();

    @OnConnect
    public void onConnect(SocketIOClient client) {
        /**
         * 获取握手时的传来的查询参数信息，username作为Key，当前会话client作为值存放对话集合
         */
        String username = client.getHandshakeData().getSingleUrlParam("username");
        socketIOClientMap.put(username, client);
        client.sendEvent("message", client.getSessionId());
        sendBroadcast();

        System.out.println(1);
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        /**
         * 断开连接时，移出服务端保存的对话
         */
        SocketIOClient socketIOClient = socketIOClientMap.get(client.getHandshakeData().getSingleUrlParam("username"));
        if (socketIOClient != null) {
            socketIOClientMap.remove(socketIOClient);
        }
        System.out.println(2);
    }
    @OnEvent(value = "messageEvent")
    public void messageEvent(SocketIOClient client, AckRequest ackRequest,String data){
        System.out.println(data);
        client.sendEvent("messageEvent","messageEvent");
    }

    public void sendBroadcast() {
        for (SocketIOClient client : socketIOClientMap.values()) {
            if (client.isChannelOpen()) {
                client.sendEvent("broadcast", "broadcast");
            }
        }
    }
}
