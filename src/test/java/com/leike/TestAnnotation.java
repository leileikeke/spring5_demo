package com.leike;

import com.leike.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-09 10:34
 */
public class TestAnnotation {

    @Test
    public void test1(){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext.xml"});

        UserService userService = context.getBean("userService", UserService.class);
        userService.eat();
    }
}
