package com.demo4.dao;

import com.demo4.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {
    public List<Admin> findAll();
    public Admin findByUsername(String username);
    public int saveAdmin(Admin admin);
}
