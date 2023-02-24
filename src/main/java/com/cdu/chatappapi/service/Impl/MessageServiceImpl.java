package com.cdu.chatappapi.service.Impl;

import com.cdu.chatappapi.entity.SingleMessage;
import com.cdu.chatappapi.mapper.MessageMapper;
import com.cdu.chatappapi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<SingleMessage> findAllSingleMsg(String username) {

        if (null == username){
            System.out.println("请先登录！");
        }

        List<SingleMessage> singleMessageList = messageMapper.findAllSingleMsg(username);

//        if (null == message){
//            System.out.println("服务器有问题！");
//        }

        return singleMessageList;
    }

    @Override
    public Integer addSingleMsg(String fromUser, String toUser, String content, Date sendTime){
        if (null == fromUser || null == toUser || null == content || null == sendTime){
            System.out.println("发送消息的各种信息不能为空！私聊");
        }

        Integer rows = messageMapper.insertSingleMsg(fromUser, toUser, content, sendTime);

        if (1 != rows){
            System.out.println("服务器问题!添加Message失败！");
        }

        return rows;
    }

    @Override
    public Integer addGroupMsg(Integer groupId, String content, String msgUsername, Date sendTime) {
        if (null == groupId || null == content || null == msgUsername || null == sendTime){
            System.out.println("发送消息的各种信息不能为空！群聊");
        }

        Integer rows = messageMapper.insertGroupMsg(groupId, content, msgUsername, sendTime);

        if (1 != rows){
            System.out.println("服务器问题!添加Message失败！");
        }

        return rows;
    }
}
