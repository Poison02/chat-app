package com.cdu.chatappapi.mapper;

import com.cdu.chatappapi.entity.GroupMessage;
import com.cdu.chatappapi.entity.SingleMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("select * from singleMessage where fromUser=#{username} or toUser=#{username}")
    List<SingleMessage> findAllSingleMsg(String username);

    @Insert("insert into singleMessage (fromUser, toUser, content, sendTime) " +
            "values (#{fromUser}, #{toUser}, #{content}, #{sendTime})")
    Integer insertSingleMsg(String fromUser, String toUser, String content, Date sendTime);

    // 查找所有群聊记录
    @Select("select * from groupMessage where groupId=#{groupId}")
    List<GroupMessage> findAllGroupMsg(Integer groupId);

    @Insert("insert into groupMessage (groupId, content, msgUsername, sendTime)" +
            "values (#{groupId}, #{content}, #{msgUsername}, #{sendTime})")
    Integer insertGroupMsg(Integer groupId, String content, String msgUsername, Date sendTime);

}
