package com.cdu.chatappapi.service.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cdu.chatappapi.entity.User;
import com.cdu.chatappapi.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {
    // 定义过期时间
    private final long expire = 50 * 60 * 1000;

    @Override
    public String getToken(User user) {
        Date date = new Date((System.currentTimeMillis() + expire));
        /**
         * 将username保存到token中，并且设置过期时间，和指定签名算法
         */
        String token = JWT.create().withAudience(user.getUsername()).withExpiresAt(date).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
