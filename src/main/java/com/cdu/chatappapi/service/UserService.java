package com.cdu.chatappapi.service;

import com.cdu.chatappapi.entity.Group;
import com.cdu.chatappapi.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 根据username获取用户信息对象
     *
     * @param username
     * @return user
     */
    User getUserByUsername(String username);

    User login(String username, String password);

    Integer register(User user);

    String findFriend(String username);

    User getFewInfo(String username);

    Integer updateAvatar(String username, String avatar);

    Integer addFriend(List<String> friendList, String username);

    List<Group> returnGroup(Integer groupId);

    String returnMembers(Integer groupId);
}
