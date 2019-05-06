package com.demo4.transaction;

import com.demo4.entity.UserLog;
import com.demo4.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Aspect
@Component
public class UserlogTransaction {
    @Autowired
    private LogService logService;

    @Pointcut(value = "execution(* com.demo4.service.AdminService.login(..))||execution(* com.demo4.service.AdminService.logoff(..))")
    private void controllerAsject(){
    }

    @Before(value = "controllerAsject()")
    public void methodBefore(JoinPoint joinPoint)throws Exception{
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 打印请求内容
//        System.out.println("===============请求内容===============");
//        System.out.println("请求地址:" + request.getRequestURL().toString());
//        System.out.println("请求方式:" + request.getMethod());
//        System.out.println("请求类方法:" + joinPoint.getSignature());
//        System.out.println("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        String string1=Arrays.toString(joinPoint.getArgs());
        String string2=joinPoint.getSignature().toString();
        int d1=string2.lastIndexOf('.');
        int d2=string2.indexOf('(');
        //System.out.println(string2+" "+d1+" "+d2);
        String action=string2.substring(d1+1,d2);
        int distance=string1.indexOf(',');
        //System.out.println(distance);
        String name;
        if (distance>1) {
            name = string1.substring(1, distance);
        }
        else {
            name=string1.substring(1,string1.length()-1);
            System.out.println(name);
        }
        UserLog userLog=new UserLog();
        userLog.setUsername(name);
        userLog.setAction(action);
        userLog.setTime(new Date().toString());
        logService.saveUserlog(userLog);
    }
}
