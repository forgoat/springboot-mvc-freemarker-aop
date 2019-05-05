package com.demo4.dao;

import com.demo4.entity.InsertLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsertLogDao {
    public int saveInsertLog(InsertLog insertLog);
    public List<InsertLog> findAll();
}
