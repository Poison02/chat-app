package com.cdu.chatappapi.mapper;

import com.cdu.chatappapi.entity.Group;
import com.cdu.chatappapi.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username=#{username}")
    User findByUsername(String username);

    @Select("select friendList from user where username=#{username}")
    String findFriend(String username);

    @Select("select username, avatar from user where username=#{username}")
    User findFewInfo(String username);

    @Insert("insert into user (username, password, salt, gender, avatar, email, phone, createdTime) " +
            "values(#{username}, #{password}, #{salt}, #{gender}, #{avatar}, #{email}, #{phone}, #{createdTime})")
    Integer register(User user);

    @Update("update user set avatar=#{avatar} where username=#{username}")
    Integer updateAvatar(@Param("username") String username,
                         @Param("avatar") String avatar);

    @Update("update user set friendList=#{friendList} where username=#{username}")
    Integer addFriend(@Param("friendList") String friendList,
                      @Param("username") String username);

    @Select("select * from group_info where group_id=#{groupId}")
    List<Group> findGroup(Integer groupId);

    @Select("select members from group_info where group_id=#{groupId}")
    String findGroupMembers(Integer groupId);
    
}
