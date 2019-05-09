package com.demo4.controller;

import com.demo4.entity.Admin;
import com.demo4.entity.Alumni;
import com.demo4.entity.InsertLog;
import com.demo4.entity.UserLog;
import com.demo4.service.AdminService;
import com.demo4.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private LogService logService;
    @GetMapping(value = "")
    public List<Admin> findAllAdmin() {
        List<Admin> adminList=adminService.findAllAdmin();
        return adminList;
    }

    @PostMapping(value = "")
    public Admin login(String username, String password) {
        System.out.println(username + " " + password);
        return adminService.login(username, password);
    }

    @PostMapping(value = "alumni")
    public int saveAlumni(Alumni alumni){
        return adminService.saveAlumni(alumni);
    }

    @GetMapping(value = "alumni")
    public List<Alumni> findAllAlumni(){
        return adminService.findAllAlumni();
    }

    @PostMapping(value = "save")
    public int saveAdmin(Admin admin){
        return adminService.saveAdmin(admin);
    }

    @PostMapping(value ="insertlog")
    public int saveInsertlog(InsertLog insertLog){
        return logService.saveInsertlog(insertLog);
    }

    @PostMapping(value = "userlog")
    public int saveUserlog(UserLog userLog){
        return logService.saveUserlog(userLog);
    }

    @DeleteMapping(value = "alumni")
    public int deleteAlumni(Integer id){
        return adminService.deleteAlumni(id);
    }

    @GetMapping(value = "findByUsername")
    public Admin findByUsername(String username){
        return adminService.findByUsername(username);
    }

    @GetMapping(value = "userlog")
    public List<UserLog> findAllUserLog(){
        return logService.findAllUserLog();
    }
    @GetMapping(value = "insertlog")
    public List<InsertLog> findAllInsertLog(){
        return logService.findAllInsertLog();
    }

    @PutMapping(value = "alumni")
    public int updateInfo(Integer id,String graduatedYear,String workingArea,String position){
        return adminService.updateAlumni(id, graduatedYear, workingArea, position);
    }
}
