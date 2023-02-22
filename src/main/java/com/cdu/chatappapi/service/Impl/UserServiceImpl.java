package com.cdu.chatappapi.service.Impl;

import com.cdu.chatappapi.entity.User;
import com.cdu.chatappapi.mapper.UserMapper;
import com.cdu.chatappapi.service.UserService;
import com.cdu.chatappapi.service.ex.InsertException;
import com.cdu.chatappapi.service.ex.UpdateException;
import com.cdu.chatappapi.service.ex.UserException;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserByUsername(String username) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UserException("用户名不存在");
        }
        return user;
    }

    @Override
    public Integer register(User user){
        User result = userMapper.findByUsername(user.getUsername());

        if (null != result){
            throw new UserException("该用户已存在！请重新输入！");
        }

        Integer rows = userMapper.register(user);

        if (1 != rows){
            throw new InsertException("服务器错误！");
        }

        return rows;
    }

    @Override
    public Integer updateAvatar(String username, String avatar) {

        if (null == username || null == avatar){
            System.out.println("不能为空！");
        }

        Integer rows = userMapper.updateAvatar(username, avatar);

        if (1 != rows){
            throw new UpdateException("服务器出错误！");
        }

        return rows;

    }
}
