package com.cdu.chatappapi.handler;

import com.cdu.chatappapi.entity.GroupMessage;
import com.cdu.chatappapi.entity.SingleMessage;
import com.cdu.chatappapi.service.MessageService;
import com.cdu.chatappapi.service.UserService;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class MessageEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageEventHandler.class);

    @Autowired
    SocketIOServer socketIOServer;

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    // 服务端保存连接的所有对话，使用username作为键和这个username的对话容器作为值
    public static ConcurrentMap<String, SocketIOClient> socketIOClientMap = new ConcurrentHashMap<>();
    // 创建一个数组保存登陆成功的用户
    List<String> onlineList = new ArrayList<>();

    @OnConnect
    public void onConnect(SocketIOClient client) {
        /**
         * 获取握手时的传来的查询参数信息，username作为 Key，当前会话 client 作为值存放对话集合
         */
        String username = client.getHandshakeData().getSingleUrlParam("username");
        if (StringUtils.isNotBlank(username)){
            LOGGER.info("用户{}成功登录, NettySocketSessionId: {}, NettySocketRemoteAddress: {}, 现在在线人数为: {}",
                    username, client.getSessionId().toString(),
                    client.getRemoteAddress().toString(), socketIOClientMap.size());
        }
        // 保存
        socketIOClientMap.put(username, client);
        // 有一个用户上线就添加进List
        onlineList.add(username);

        client.sendEvent("message", client.getSessionId());
        sendBroadcast();
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        /**
         * 断开连接时，移出服务端保存的对话
         */
        SocketIOClient socketIOClient = socketIOClientMap.get(
                client.getHandshakeData().getSingleUrlParam("username"));

        String username = client.getHandshakeData().getSingleUrlParam("username");
        // 断开连接就从列表中删除
        if (null != onlineList){
            onlineList.remove(username);
        }

        if (socketIOClient != null) {
            socketIOClientMap.remove(socketIOClient);
        }

        LOGGER.info("用户{}已经注销, 现在在线人数为: {}", username, socketIOClientMap.size());
    }

    // 私聊
    @OnEvent(value = "sendSingleMessageEvent")
    public void sendSingleMessageEvent(SocketIOClient client, AckRequest ackRequest, SingleMessage singleMessage){

        // 得到发送方的客户端容器，后面再进行发送以及存储数据库的功能
        SocketIOClient toUserClient = socketIOClientMap.get(singleMessage.getToUser());
        // 在线
        if (null != toUserClient){
            toUserClient.sendEvent("receiveSingleMessageEvent", singleMessage);
        }

        messageService.addSingleMsg(singleMessage.getFromUser(),
                singleMessage.getToUser(),
                singleMessage.getContent(),
                singleMessage.getSendTime()
        );
    }

    // 群聊
    @OnEvent(value = "sendGroupMessageEvent")
    public void groupMessageEvent(SocketIOClient client, AckRequest ackRequest, GroupMessage groupMessage){

        // 查看map看哪些用户在线, 首先从数据库中查找出群组中的用户列表
//        String result = userService.returnMembers(groupMessage.getGroupId());
//        List<String> list = members(result);
//        list.remove(groupMessage.getMsgUsername());
        ConcurrentMap<String, SocketIOClient> copyMap = new ConcurrentHashMap<>();
        copyMap.putAll(socketIOClientMap);
        copyMap.remove(groupMessage.getMsgUsername(), copyMap.get(groupMessage.getMsgUsername()));

        for (SocketIOClient userClient : copyMap.values()) {
            if (userClient.isChannelOpen()) {
                userClient.sendEvent("receiveGroupMessageEvent", groupMessage);
            }
        }

        // 存进数据库
        messageService.addGroupMsg(
                groupMessage.getGroupId(),
                groupMessage.getContent(),
                groupMessage.getMsgUsername(),
                groupMessage.getSendTime()
        );

    }

    public void sendBroadcast() {
        for (SocketIOClient client : socketIOClientMap.values()) {
            if (client.isChannelOpen()) {
                client.sendEvent("broadcast", "broadcast");
            }
        }
    }

    public List<String> members(String member){
        String demosub = member.substring(1,member.length()-1).replaceAll(" ", "");
        String[] demoArray = demosub.split(",");
        List<String> result = Arrays.asList(demoArray);
        return result;
    }
}
