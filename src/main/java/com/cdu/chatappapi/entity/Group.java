package com.cdu.chatappapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    private Integer groupId;

    private String groupName;

    private String groupAvatar;

    private List<String> members;
}
