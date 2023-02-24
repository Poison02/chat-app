package com.cdu.chatappapi.service;

import com.cdu.chatappapi.entity.GroupMessage;
import com.cdu.chatappapi.entity.SingleMessage;

import java.util.List;

public interface ChatService {

    // 返回私聊消息
    List<SingleMessage> returnSingleMsg();

    // 返回群聊消息
    List<GroupMessage> returnGroupMsg(Integer groupId);


}
