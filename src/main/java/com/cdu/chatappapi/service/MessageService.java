package com.cdu.chatappapi.service;

import com.cdu.chatappapi.entity.SingleMessage;

import java.util.Date;
import java.util.List;

public interface MessageService {

    List<SingleMessage> findAllSingleMsg(String username);

    Integer addSingleMsg(String fromUser, String toUser, String content, Date sendTime);

    Integer addGroupMsg(Integer groupId, String content, String msgUsername, Date sendTime);
}
