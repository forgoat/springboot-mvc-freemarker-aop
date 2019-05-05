package com.demo4.controller;

import com.demo4.entity.Admin;
import com.demo4.entity.Alumni;
import com.demo4.entity.UserLog;
import com.demo4.service.AdminService;
import com.demo4.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private LogService logService;
    @PostMapping(value = "manager")
    public String login(Model model, @RequestParam("username")String username,@RequestParam("password")String password){
        Admin admin=adminService.login(username,password);
        if (admin!=null){
            model.addAttribute("admin",admin);
            return "manager";
        }
        else {
            return "/";
        }
    }

    @GetMapping(value = "alumni")
    public String findAllAlumni(Model model,@RequestParam("username")String username){
        List<Alumni> alumniList=adminService.findAllAlumni();
        model.addAttribute("alumnis",alumniList);
        model.addAttribute("username",username);
        return "alumni";
    }

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "manager")
    public String manager(){
        return "manager";
    }
    @PostMapping(value = "logoff")
    public String logoff(Model model,@RequestParam("username")String username){
        UserLog userLog=new UserLog();
        userLog.setAction("logOut");
        userLog.setUsername(username);
        Date date=new Date();
        userLog.setTime(date.toString());
        System.out.println(userLog.toString());
        return "index";
    }

    @PostMapping(value = "deleteAlumni")
    public String deleteAlumni(Model model,@RequestParam("id")Integer id){
        if (adminService.deleteAlumni(id)==1){
            return "redirect:alumni";
        }
        else {
            return "redirect:alumni";
        }
    }

    @PostMapping(value = "saveAlumni")
    public String saveAlumni(Model model,Alumni alumni){
        if (adminService.saveAlumni(alumni)==1){
            model.addAttribute("alumnis",adminService.findAllAlumni());
            return "redirect:alumni";
        }
        return "redirect:alumni";
    }

    @GetMapping(value = "getBack")
    public String getBack(Model model,@RequestParam("username")String username){
        Admin admin=adminService.findByUsername(username);
        if (admin!=null){
            model.addAttribute("admin",admin);
            return "manager";
        }
        else {
            return "/";
        }
    }

    @GetMapping(value = "log")
    public String getUserLog(Model model,@RequestParam("username")String username){
        List<UserLog> userLogs=logService.findAllUserLog();
        model.addAttribute("userlog",userLogs);
        model.addAttribute("username",username);
        return "Alllog";
    }
}
