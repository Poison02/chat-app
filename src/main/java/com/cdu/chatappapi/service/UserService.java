package com.cdu.chatappapi.service;

import com.cdu.chatappapi.entity.User;

public interface UserService {
    /**
     * 根据username获取用户信息对象
     *
     * @param username
     * @return user
     */
    User getUserByUsername(String username);

    Integer register(User user);

    Integer updateAvatar(String username, String avatar);
}
