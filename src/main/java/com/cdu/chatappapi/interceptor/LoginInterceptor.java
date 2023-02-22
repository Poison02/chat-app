package com.cdu.chatappapi.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cdu.chatappapi.entity.User;
import com.cdu.chatappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {
   @Autowired
   UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 通过HTTP 请求头获取JWT token
        String token = request.getHeader("token");

        if (token == null) {
            throw new LoginException("token不存在，请重新登录");
        }
        String username;
        // 获取token中的uid
        try {
            username = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException jwtDecodeException) {
            throw new LoginException("token 解码失败");
        }
        // 通过username获取到对象
        User user = userService.getUserByUsername(username);

        // 生成token验证器
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        // 验证token
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException jwtVerificationException) {
            throw new LoginException("token验证失败，请重新登录");
        }
        return true;
    }
}
