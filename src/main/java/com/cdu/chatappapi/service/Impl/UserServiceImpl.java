package com.cdu.chatappapi.service.Impl;

import com.cdu.chatappapi.entity.Group;
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
import java.util.List;
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
    public String findFriend(String username){
        if (null == username){
            System.out.println("这里是查找好友列表，出错！");
        }

        String list = userMapper.findFriend(username);

        if (null == list){
            System.out.println("没有任何的好友！");
        }

        return list;
    }

    @Override
    public User getFewInfo(String username){
        if (null == username){
            System.out.println("没有好友和群组！");
        }

        User user = userMapper.findFewInfo(username);

        if (null == user){
            System.out.println("查不出来名字和头像！");
        }

        return user;
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

    @Override
    public Integer addFriend(List<String> friendList, String username) {

        if (null == friendList){
            System.out.println("加好友不能为空！");
        }
        if (null == username){
            System.out.println("请指定谁要加好友！");
        }

        Integer rows = userMapper.addFriend(friendList.toString(), username);
        if (1 != rows){
            System.out.println("加好友服务器有问题！");
        }

        return rows;
    }

    @Override
    public List<Group> returnGroup(Integer groupId){
        if (null == groupId){
            System.out.println("您未加入任何群组！");
        }

        List<Group> groupList = userMapper.findGroup(groupId);

        if (null == groupList){
            System.out.println("查找群组 服务器有问题！");
        }

        return groupList;
    }

    @Override
    public String returnMembers(Integer groupId) {
        return userMapper.findGroupMembers(groupId);
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
