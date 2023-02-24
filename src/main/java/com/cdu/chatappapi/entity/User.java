package com.cdu.chatappapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    Integer uid;

    String username;

    String password;

    String salt;

    Integer gender;

    String avatar;

    String email;

    String phone;

    Date createdTime;

    // 好友列表
    private List<String> friendList;

    private Integer groupId;

}
