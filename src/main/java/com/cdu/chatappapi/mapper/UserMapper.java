package com.cdu.chatappapi.mapper;

import com.cdu.chatappapi.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username=#{username}")
    User findByUsername(String username);

    @Insert("insert into user (username, password, salt, gender, avatar, email, phone, createdTime) " +
            "values(#{username}, #{password}, #{salt}, #{gender}, #{avatar}, #{email}, #{phone}, #{createdTime})")
    Integer register(User user);

    @Update("update user set avatar=#{avatar} where username=#{username}")
    Integer updateAvatar(String username, String avatar);
    
}
