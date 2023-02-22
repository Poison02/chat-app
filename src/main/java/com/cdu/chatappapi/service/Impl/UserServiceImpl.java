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
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserByUsername(String username) {
        User result = userMapper.findByUsername(username);
        if (result == null) {
            throw new UserException("用户名不存在");
        }
        return result;
    }

    @Override
    public User login(String username, String password){

        User result = userMapper.findByUsername(username);
        if (null == result){
            throw new UserException("用户名不存在！");
        }

        if (! result.getPassword().equals(md5Pwd(password, result.getSalt()))){
            throw new UserException("密码错误！");
        }

        return result;
    }

    @Override
    public Integer register(User user){
        User result = userMapper.findByUsername(user.getUsername());

        if (null != result){
            throw new UserException("该用户已存在！请重新输入！");
        }

        // 补充数据，创建默认头像
        user.setAvatar("static/img/avatar/default.png");
        Date createdTime = new Date();
        user.setCreatedTime(createdTime);
        user.setSalt(UUID.randomUUID().toString());
        user.setPassword(md5Pwd(user.getPassword(), user.getSalt()));

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


    // 加密密码方法
    public String md5Pwd(String password, String salt){

        // 进行三次加密
        for (int i = 0; i < 3; i++) {
            // 将传入的字节通过计算保持到16位字符，并返回
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes());
        }

        return password;
    }
}
