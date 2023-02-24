package com.cdu.chatappapi.service.Impl;

import com.cdu.chatappapi.entity.Group;
import com.cdu.chatappapi.entity.GroupMessage;
import com.cdu.chatappapi.entity.SingleMessage;
import com.cdu.chatappapi.mapper.MessageMapper;
import com.cdu.chatappapi.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<SingleMessage> returnSingleMsg() {
        return null;
    }

    @Override
    public List<GroupMessage> returnGroupMsg(Integer groupId) {

        if (null == groupId){
            System.out.println("这个人没有加入任何的群组！");
        }
        List<GroupMessage> messageList = messageMapper.findAllGroupMsg(groupId);

        if (null == messageList){
            System.out.println("这个群没有任何消息！");
        }

        return messageList;
    }
}
