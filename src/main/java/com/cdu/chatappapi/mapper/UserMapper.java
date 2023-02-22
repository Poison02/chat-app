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

    @Insert("insert into user (username, password) values(#{username}, #{password})")
    Integer register(User user);

    @Update("update user set avatar=#{avatar} where username=#{username}")
    Integer updateAvatar(String username, String avatar);
    
}
