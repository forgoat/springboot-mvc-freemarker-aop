package com.demo4.dao;

import com.demo4.entity.UserLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserLogDao {
    public int saveUserLog(UserLog userLog);
    public List<UserLog> findAll();
}
