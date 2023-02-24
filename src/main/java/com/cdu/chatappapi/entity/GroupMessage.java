package com.cdu.chatappapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupMessage {

    private Integer gId;

    private Integer groupId;

    private String msgUsername;

    private String content;

    private Date sendTime;
}
