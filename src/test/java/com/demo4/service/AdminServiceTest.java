package com.demo4.service;

import com.demo4.dao.AdminDao;
import com.demo4.entity.Admin;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;
    @MockBean
    private AdminDao adminDao;

    @Test
    public void findAllAdmin() {
        List<Admin> adminList=adminService.findAllAdmin();
        for (Admin admin:adminList){
            System.out.println(admin.toString());
        }
    }

    @Test
    public void login() {
        Admin admin=new Admin();
        admin=adminService.findByUsername("lin");
        Admin resultPosAdmin=adminService.login("lin","123456");
        Admin resultNegAdmin=adminService.login("wu","happy");
        Assertions.assertThat(resultPosAdmin).isEqualTo(admin);
        Assertions.assertThat(resultNegAdmin).isEqualTo(null);
    }
}