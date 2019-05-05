package com.demo4.service;

import com.demo4.dao.InsertLogDao;
import com.demo4.dao.UserLogDao;
import com.demo4.entity.InsertLog;
import com.demo4.entity.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private UserLogDao userLogDao;
    @Autowired
    private InsertLogDao insertLogDao;

    public int saveUserlog(UserLog userLog){
        return userLogDao.saveUserLog(userLog);
    }

    public int saveInsertlog(InsertLog insertLog){
        return insertLogDao.saveInsertLog(insertLog);
    }

    public List<UserLog> findAllUserLog(){
        return userLogDao.findAll();
    }

    public List<InsertLog> findAllInsertLog(){
        return insertLogDao.findAll();
    }
}
