package com.cdu.chatappapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

}
