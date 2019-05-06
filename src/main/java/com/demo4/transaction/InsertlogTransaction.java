package com.demo4.transaction;

import com.demo4.entity.InsertLog;
import com.demo4.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class InsertlogTransaction {
    @Autowired
    private LogService logService;
    @Pointcut(value = "execution(* com.demo4.service.AdminService.saveAlumni(..))")
    private void controllerAspect(){
    }

    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint)throws Exception{
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
//        System.out.println("===============请求内容===============");
//        System.out.println("请求地址:" + request.getRequestURL().toString());
//        System.out.println("请求方式:" + request.getMethod());
//        System.out.println("请求类方法:" + joinPoint.getSignature());
//        System.out.println("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        InsertLog insertLog=new InsertLog();
        insertLog.setTime(new Date().toString());
        insertLog.setValue(Arrays.toString(joinPoint.getArgs()));
        logService.saveInsertlog(insertLog);
    }
}
