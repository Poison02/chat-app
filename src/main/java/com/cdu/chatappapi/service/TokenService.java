package com.cdu.chatappapi.service;

import com.cdu.chatappapi.entity.User;

public interface TokenService {
    /**
     * 生成JWT Token
     *
     * @param user
     * @return token
     */
    String getToken(User user);
}
