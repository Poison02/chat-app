package com.cdu.chatappapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SingleMessage {

    private Integer mId;

    private String fromUser;

    private String toUser;

    private String content;

    private Date sendTime;
}
